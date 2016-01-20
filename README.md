[![Build Status](https://travis-ci.org/pmonks/bookmark-writer.svg?branch=master)](https://travis-ci.org/pmonks/bookmark-writer)
[![Dependencies Status](http://jarkeeper.com/pmonks/bookmark-writer/status.svg)](http://jarkeeper.com/pmonks/bookmark-writer)

# bookmark-writer

A simple and dumb Clojure library that provides the ability to set the text values of bookmarks in Word 2007 (.docx) format files.
Little more than a Clojure wrapper around [this docx4j sample class](https://github.com/plutext/docx4j/blob/master/src/samples/docx4j/org/docx4j/samples/BookmarksReplaceWithText.java).

## Installation

`bookmark-writer` is available as a Maven artifact from [Clojars](https://clojars.org/org.clojars.pmonks/bookmark-writer):

[![version](https://clojars.org/org.clojars.pmonks/bookmark-writer/latest-version.svg)](https://clojars.org/org.clojars.pmonks/bookmark-writer)

## Usage

The library's functionality is provided in the `bookmark-writer.core` namespace.

Require it in the REPL:

```clojure
(require '[bookmark-writer.core :as bm])
```

Require it in your application:

```clojure
(ns my-app.core
  (:require [bookmark-writer.core :as bm]))
```

TODO: provide example usage instructions.

## Developer Information

[GitHub project](https://github.com/pmonks/bookmark-writer)

[Bug Tracker](https://github.com/pmonks/bookmark-writer/issues)

[![endorse](https://api.coderwall.com/pmonks/endorsecount.png)](https://coderwall.com/pmonks)

## License

Copyright © 2013-2016 Peter Monks (pmonks@gmail.com)

Distributed under the [Eclipse Public License](http://www.eclipse.org/legal/epl-v10.html) either version 1.0 or (at your option) any later version.
