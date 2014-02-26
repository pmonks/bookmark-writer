;
; Copyright © 2014 Peter Monks (pmonks@gmail.com)
;
; All rights reserved. This program and the accompanying materials
; are made available under the terms of the Eclipse Public License v1.0
; which accompanies this distribution, and is available at
; http://www.eclipse.org/legal/epl-v10.html
;
; Contributors:
;    Peter Monks - initial implementation

(defproject org.clojars.pmonks/bookmark-writer "0.2.0-SNAPSHOT"
  :description      "A simple and dumb Clojure library that provides the ability to set the text values of bookmarks in Word 2007 (.docx) format files."
  :url              "https://github.com/pmonks/bookmark-writer"
  :license          {:name "Eclipse Public License"
                     :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.0.0"
  :dependencies [
                  [org.clojure/clojure            "1.5.1"]
                  [org.clojure/tools.logging      "0.2.6"]
                  [ch.qos.logback/logback-classic "1.1.1"]
                  [org.docx4j/docx4j              "3.0.1" :exclusions [log4j org.slf4j/slf4j-log4j12]]
                ]
  :profiles {:dev {:dependencies [
                                   [midje          "1.6.2"]
                                   [clj-ns-browser "1.3.1"]
                                 ]}
             :uberjar {:aot :all}}
  :uberjar-merge-with {#"META-INF/services/.*" [slurp str spit]}   ; Merge Java ServiceLocator descriptors during uberjar construction
  :source-paths      ["src/clojure"]
  :java-source-paths ["src/java"]
  :jvm-opts ^:replace []  ; Stop Leiningen from turning off JVM optimisations - makes it slower to start but ensures code runs as fast as possible
  :main bookmark-writer.core)
