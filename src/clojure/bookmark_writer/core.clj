;
; Copyright © 2013,2014 Peter Monks (pmonks@gmail.com)
;
; This work is licensed under the Creative Commons Attribution-ShareAlike 3.0
; Unported License. To view a copy of this license, visit
; http://creativecommons.org/licenses/by-sa/3.0/ or send a letter to Creative
; Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041, USA.
;

(ns bookmark-writer.core
  (:require [clojure.tools.logging :as log])
  (:gen-class))

(def ^:private test-filename "test/test.docx")
(def ^:private test-output-filename "test/testoutput.safetodelete.docx")
(def ^:private bookmark-map { "BM_Text"             "#THIS TEXT WAS INSERTED INTO BOOKMARK \"BM_Text\"#",
                              "BM_NoText"           "#THIS TEXT WAS INSERTED INTO BOOKMARK \"BM_NoText\"#",
                              "BM_InTable"          "#THIS TEXT WAS INSERTED INTO BOOKMARK \"BM_InTable\"#",
                              "NonExistentBookmark" "!!THIS TEXT SHOULD NOT BE VISIBLE ANYWHERE!!" })

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
   for those bookmarks), and then writes the resulting Word document to the file identified by output-document."
  [input-document
   output-document
   bookmark-map]
  (let [template-document (org.docx4j.Docx4J/load input-document)]
    (replace-bookmark-text! template-document bookmark-map)
    (org.docx4j.Docx4J/save template-document (clojure.java.io/file output-document) org.docx4j.Docx4J/FLAG_SAVE_ZIP_FILE)))

(defn -main
  "Simple and dumb test case."
  [& args]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))

  (populate-bookmarks! (clojure.java.io/file test-filename) test-output-filename bookmark-map))
