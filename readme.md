# QuickFIX/J Customisation Examples 

![](./FIXorchestraLogo.png)

# Introduction

The repository contains examples of customisation when building from a FIX Orchestra specification.

The examples are contrived and are only for the purpose of showing some of the ways that customisation can be accomplished.

The purpose of such customisation is to produce succinct Rules of Engagement and to generate the QuickFIX/J classes that 
assist in writing typesafe code for Messages, Components. Groups and Fields.

`./src/main/resources` contains an example FIX Orchestra file containing a very minimal set of messages and fields.
This example is not intended as a reference for a good Rules Of Engagement.

The example FIX Orchestra file was prepared using "Playlist" which is available to FIX Trading Community members at the 
[Fix Trading Community](https://www.fixtrading.org/) site.

The more complete documents for customising QuickFIX/J are available on the 
[QuickFIX/J github repository](https://github.com/quickfix-j/quickfixj).

[Customising QuickFIX/J](https://github.com/quickfix-j/quickfixj/blob/master/customising-quickfixj.md) may be a good starting point.

See also [QuickFIX/J Orchestra](https://github.com/quickfix-j/quickfixj-orchestra).

## Recommended Approaches to customisation

* Build custom packages only for the required FIX protocol versions 

   For example build only FIX50SP2 or FIXlatest. You can build more than one of course, but only maintain what you need.
* Regard FIXT11 as a responsibility of the QuickFIX/J project
  
   Unless you need to customise FXIT11, use the artifacts from the QuickFIX/J project
* Consider building using the legacy (original) code generator if you don't want the FIXlatest protocol version and:
  * have legacy code using older versions of QuickFIX/J and want to benefit from QuickFIX/J 3.0.0 while minimising code changes 
  * have legacy customisations using QuickFIX dictionaries and want to defer customising using FIX Orchestra

## Project structure

\-custom-application-messages : builds custom Application classes using FIX Orchestra.

\-custom-legacy-code-application-messages :  builds custom Application classes from a QuickFIX dictionary using the legacy QuickFIX/j code generation.

# Build

## Maven

 `mvn clean install -Djdk.xml.xpathExprGrpLimit=1024 -Djdk.xml.xpathExprOpLimit=1024`

Faster without javadoc

`mvn clean install -Djdk.xml.xpathExprGrpLimit=1024 -Djdk.xml.xpathExprOpLimit=1024 -Dmaven.javadoc.skip=true`
