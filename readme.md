# QuickFIX/J Customisation Examples 

![](./FIXorchestraLogo.png)

#Introduction

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

#Build

 `mvn clean install -Djdk.xml.xpathExprGrpLimit=1024 -Djdk.xml.xpathExprOpLimit=1024`
