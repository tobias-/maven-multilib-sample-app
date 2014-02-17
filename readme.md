# Maven sample app

## Abstract

While the app does nothing, it combines lots of technologies that needs some special
care to get them to work together.

It combines the following:
* Maven (with android-maven-plugin)
* Eclipse-integration (both AA and maven)
* Facebook
* Multi-lib (Facebook and Common)
  Useful when having two apps that share lots of functionality
  e.g. paid and non-paid, branded apps or just layout reuse
* Instrumentation Tests
* Android Annotations

## Installation

git clone the url at the top, i.e.
```git clone maven-sample-app```

To get it working as smoothly as possible, I highly recommend cloning and installing
https://github.com/mosabua/maven-android-sdk-deployer

To get Eclipse working I recommend EE edition with "m2e" and "Android Configuration for M2E". Any Eclipse version should
theoretically work though.
