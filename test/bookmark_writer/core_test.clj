;
; Copyright © 2014-2016 Peter Monks (pmonks@gmail.com)
;
; All rights reserved. This program and the accompanying materials
; are made available under the terms of the Eclipse Public License v1.0
; which accompanies this distribution, and is available at
; http://www.eclipse.org/legal/epl-v10.html
;
; Contributors:
;    Peter Monks - initial implementation

(ns bookmark-writer.core-test
  (:require [midje.sweet           :refer :all]
            [bookmark-writer.core  :refer :all]))


(def ^:private test-filename        "test/test.docx")
(def ^:private test-output-filename "test/testoutput.safetodelete.docx")
(def ^:private bookmark-map         { "BM_Text"             "#THIS TEXT WAS INSERTED INTO BOOKMARK \"BM_Text\"#",
                                      "BM_NoText"           "#THIS TEXT WAS INSERTED INTO BOOKMARK \"BM_NoText\"#",
                                      "BM_InTable"          "#THIS TEXT WAS INSERTED INTO BOOKMARK \"BM_InTable\"#",
                                      "NonExistentBookmark" "!!THIS TEXT SHOULD NOT BE VISIBLE ANYWHERE!!" })

; Note: the output file should also be checked for validity - the unit test doesn't currently check that
(fact
  (populate-bookmarks! test-filename test-output-filename bookmark-map) => nil)

;####TODO: add checks for document fidelity
