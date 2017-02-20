gradle-ekstazi-plugin
======================

Gradle plugin to run tests with [Ekstazi](http://www.ekstazi.org/index.html) - the lightweight test selection
library.

Ekstazi computes the dependencies of each test and determines which ones need to be run after a code change. So,
rather than running the whole test suite, Ekstazi will only run tests whose behavior may be affected by recent changes.

Usage
-----
Add the following to buildscript:
```groovy
buildscript {
  repositories {
    jcenter()
  }
  dependencies {
    classpath "com.kageiit:gradle-ekstazi-plugin:0.1.0"
  }
}

apply plugin: "com.kageiit.ekstazi"
```

You can configure the plugin with a few options
```groovy
ekstazi {
  version = '4.6.3' // The version of ekstazi to use
  forceFailing = true // Forces re-running failing tests always
  mode = 'junit' // junit is the default. For other modes, see http://www.ekstazi.org/agent.html
}
```

After applying the plugin, the typical workflow would be
- Run tests (runs all tests the first time)
- Make code changes
- Run tests (Ekstazi runs only the tests that are affected by the code changes)
- Repeat

License
-------

```
The MIT License (MIT)

Copyright (c) 2017 Gautam Korlam

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
