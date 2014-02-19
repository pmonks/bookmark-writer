;
; Copyright © 2013 Peter Monks (pmonks@gmail.com)
;
; This work is licensed under the Creative Commons Attribution-ShareAlike 3.0
; Unported License. To view a copy of this license, visit
; http://creativecommons.org/licenses/by-sa/3.0/ or send a letter to Creative
; Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041, USA.
;

(defproject bookmark-writer "0.1.0-SNAPSHOT"
  :min-lein-version "2.0.0"
  :description "A simple and dumb Clojure library that provides the ability to set the text values of bookmarks in Word 2007 (.docx) format files."
  :url "https://github.com/pmonks/bookmark-writer"
  :license {:name "Creative Commons Attribution-ShareAlike 3.0 Unported License."
            :url "http://creativecommons.org/licenses/by-sa/3.0/"}
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
  :resource-paths    ["config"]
  :source-paths      ["src/clojure"]
  :java-source-paths ["src/java"]
  :jvm-opts ^:replace []  ; Stop Leiningen from turning off JVM optimisations - makes it slower to start but ensures code runs as fast as possible
  :main bookmark-writer.core)
