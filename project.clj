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

(defproject org.clojars.pmonks/bookmark-writer "0.2.0-SNAPSHOT"
  :description      "A simple and dumb Clojure library that provides the ability to set the text values of bookmarks in Word 2007 (.docx) format files."
  :url              "https://github.com/pmonks/bookmark-writer"
  :license          {:name "Eclipse Public License"
                     :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.5.0"
  :dependencies [
                  [org.clojure/clojure            "1.8.0"]
                  [org.clojure/tools.logging      "0.3.1"]
                  [ch.qos.logback/logback-classic "1.1.4"]
                  [org.docx4j/docx4j              "3.2.2" :exclusions [log4j org.slf4j/slf4j-log4j12]]
                ]
  :profiles {:dev {:dependencies [[midje      "1.8.3"]]
                   :plugins      [[lein-midje "3.2"]]}   ; Don't remove this or travis-ci will assplode!
             :uberjar {:aot :all}}
  :source-paths      ["src/clojure"]
  :java-source-paths ["src/java"])
