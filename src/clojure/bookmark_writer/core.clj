;
; Copyright © 2013 Peter Monks (pmonks@gmail.com)
;
; All rights reserved. This program and the accompanying materials
; are made available under the terms of the Eclipse Public License v1.0
; which accompanies this distribution, and is available at
; http://www.eclipse.org/legal/epl-v10.html
;
; Contributors:
;    Peter Monks - initial implementation

(ns bookmark-writer.core
  (:require [clojure.tools.logging :as log]
            [clojure.java.io       :as io])
  (:gen-class))

(defn- make-stupid-docx4j-map
  [bookmark-name-value-map]
  (reduce merge (map #(hash-map (org.docx4j.model.fields.merge.DataFieldName. %) (get bookmark-name-value-map %)) (keys bookmark-name-value-map))))

(defn- replace-bookmark-text!
  [^org.docx4j.openpackaging.packages.WordprocessingMLPackage wordml-pkg
   ^java.util.Map bookmark-name-value-map]
  (let [corrected-map (make-stupid-docx4j-map bookmark-name-value-map)]
    (org.docx4j.samples.BookmarksReplaceWithText/replaceBookmarkContents (-> wordml-pkg .getMainDocumentPart
                                                                                        .getJaxbElement
                                                                                        .getBody
                                                                                        .getContent)
                                                                         corrected-map)))

(defn populate-bookmarks!
  "Reads the file identified by input-document (which must be a valid Office XML document), replaces the text
   of all bookmarks in that document with the values defined in the bookmark-map (keys=bookmark names, values=desired text
   for each bookmark), and then writes the resulting Word document to the file identified by output-document (which can be
   either a java.io.File or a filename String).
   Note: nested and overlapping bookmarks probably won't work!"
  [input-document
   output-document
   bookmark-map]
  (let [template-document (org.docx4j.Docx4J/load (io/file input-document))]
    (replace-bookmark-text! template-document bookmark-map)
    (org.docx4j.Docx4J/save template-document (io/file output-document) org.docx4j.Docx4J/FLAG_SAVE_ZIP_FILE)))
