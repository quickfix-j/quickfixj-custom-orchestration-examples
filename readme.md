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

## Recommended Approaches to customisation

* Build custom packages only for the required FIX protocol versions 

   For example build only FIX50SP2 or FIXlatest. You can build more than one of course, but only maintain what you need.
* Regard FIXT11 as a responsibility of the QuickFIX/J project
  
   Unless you need to customise FXIT11, use the artifacts from the QuickFIX/J project
* Consider building using the legacy (original) code generator if you don't want the FIXlatest protocol version and:
  * have legacy code using older versions of QuickFIX/J and want to benefit from QuickFIX/J 3.0.0 while minimising code changes 
  * have legacy customisations using QuickFIX dictionaries and want to defer customising using FIX Orchestra
* Consider customising using FIX Orchestra if you want to track the FIX Latest standard and benefit from the extensions 
to the FIX Protocol after FIX 5.0sp2.
  * You may also benefit from tools that support FIX Orchestra.
  * Note that you can also generate a QuickFIX/J dictionary from a FIX Orchestra specification and use that 
    with the legacy QuickFIX/J code generator.

## Project structure
```
.
├──legacy-codegen : builds QuickFIX/J classes from a custom QuickFIX dictionary using the legacy QuickFIX/j code generation, and example applications.
├──orchestra      : builds custom QuickFIX/J classes using FIX Orchestra, and examples applications.
```

## Note:

* the typesafe use of customised SecurityIDSource and the addition of QuoteMsgID to the Execution Report message.
* the use of the QuickFIX/J base, core and FIXT1.1 package dependencies from the standard build of QuickFIX/J alongside
  the customised messages package.
* the differences in the application.yml files, specifying the FIX protocol version and the FIX dictionary.

## Example Applications, How To
[Example Applications](./readme-custom-applications.md)

# Build

## Maven

 `mvn clean install -Djdk.xml.xpathExprGrpLimit=1024 -Djdk.xml.xpathExprOpLimit=1024`

The build runs a little faster if one skips javadoc generation

`mvn clean install -Djdk.xml.xpathExprGrpLimit=1024 -Djdk.xml.xpathExprOpLimit=1024 -Dmaven.javadoc.skip=true`

# References 
### This project
* [legacy codegen readme](./legacy-codegen/readme.md)
* [orchestra readme](./orchestra/readme.md)

### FIX Orchestra
* [FIX Orchestra](https://github.com/FIXTradingCommunity/orchestra)
* [FIX Orchestra Examples](https://github.com/FIXTradingCommunity/orchestra-examples)

### QuickFIX/J
* [QuickFIX/J](https://github.com/quickfixengine/quickfixj)
* [Customising Quickfixj](https://github.com/quickfix-j/quickfixj/blob/master/customising-quickfixj.md)
* [Customising Quickfixj Detailed](https://github.com/quickfix-j/quickfixj/blob/master/quickfixj-messages/readme.md)
* [QuickFIX/J Orchestra](https://github.com/quickfix-j/quickfixj-orchestra)

### Spring Boot Starter
* [Spring Boot Starter](https://github.com/esanchezros/quickfixj-spring-boot-starter)
* [Spring Boot Starter Examples](https://github.com/esanchezros/quickfixj-spring-boot-starter-examples) 
