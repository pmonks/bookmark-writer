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

(defproject org.clojars.pmonks/bookmark-writer "0.2.0-SNAPSHOT"
  :description       "A simple and dumb Clojure library that provides the ability to set the text values of bookmarks in Word 2007 (.docx) format files."
  :url               "https://github.com/pmonks/bookmark-writer"
  :license           {:name "Eclipse Public License"
                      :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version  "2.8.1"
  :dependencies      [
                       [org.clojure/clojure             "1.9.0"]
                       [org.clojure/tools.logging       "0.4.1"]
                       [ch.qos.logback/logback-classic  "1.2.3"]
                       [org.docx4j/docx4j               "6.0.1" :exclusions [log4j org.slf4j/slf4j-log4j12]]
                       [javax.xml.bind/jaxb-api         "2.4.0-b180830.0359"]   ; Required as of JDK11
                       [org.glassfish.jaxb/jaxb-runtime "2.4.0-b180830.0438"]   ; Required as of JDK11
                     ]
  :profiles          {:dev {:dependencies [[midje      "1.9.3"]]
                            :plugins      [[lein-midje "3.2.1"]]}
                     :uberjar {:aot :all}}
  :source-paths      ["src/clojure"]
  :java-source-paths ["src/java"])
