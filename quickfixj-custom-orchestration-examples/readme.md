# QuickFIX/J Customisation Examples 

![](./FIXorchestraLogo.png)

The repository contains examples of customisation when building from a [FIX Orchestra](https://github.com/quickfix-j/quickfixj-orchestra) specification.

The examples are contrived and are only for the purpose of showing some of the ways that customisation can be accomplished.

The purpose of such customisation is to produce succinct Rules of Engagement and to generate the QuickFIX/J classes that 
assist in writing typesafe code for Messages, Components. Groups and Fields.

The more complete documents for customising QuickFIX/J are available on the 
[QuickFIX/J github repository](https://github.com/quickfix-j/quickfixj).

[Customising QuickFIX/J](https://github.com/quickfix-j/quickfixj/blob/master/customising-quickfixj.md) may be a good starting point.

See also [QuickFIX/J Orchestra](https://github.com/quickfix-j/quickfixj-orchestra).

## Project Structure

`./src/main/resources` contains an example FIX Orchestra file containing a very minimal set of messages and fields.
This example is not intended as a reference for a good Rules Of Engagement.

The example FIX Orchestra file was prepared using "Playlist" which is available to FIX Trading Community members at the
[Fix Trading Community](https://www.fixtrading.org/) site.

| Module                                  | Description                                                                                                                                                                                                                                            |
|-----------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| custom-application-and-session-messages | Demonstrates how to generate packages for both the FIXT11 Session protocol and Application Messages together. This is not the recommended way to work with QuickFIX/J and FIX Orchestra but it is conceivable.                                         |
| custom-application-messages             | Demonstrates how to generate customisations for FIX Application Messages, leaving the FIXT1.1 Session protocol packages to be distributed by the QuickFIX/J project. This is the recommended way to customise using QuickFIX/J and FIX Orchestra |

