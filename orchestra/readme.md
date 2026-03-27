# Customisation with Orchestra

This module demonstrates customisation using FIX Orchestra. It is a similar example to the legacy codegen module but with the customisation implemented using FIX Orchestra.

There are two example modules to show the QuickFix/J classes can be generated for **FIX50SP2** (_or other legacy FIX versions_) or **FIXLatest**.
Supporting older FIX versions allows the use of FIX Orchestra while providing continuity with the version of FIX that your integrations currently use.
In other words, you do not have to mandate the FIXLatest version to use FIX Orchestra. 

You can use one Orchestra file to maintain your rules of engagement and by using automation support both FIX Versions side by side.

The Orchestra files are based on the standard but have been customised using "Playlist" which is available to FIX Trading Community members at the
[Fix Trading Community](https://www.fixtrading.org/) site. The customisations are contrived for the purpose of example only.

The specifications for FIXT1.1 messages are present in the custom Orchestra files. 
This is just to provide an example of one way to remove FIXT1.1 using XSL as part of the build process.
You could simply maintain Orchestra files for Application messages without FIXT1.1 message specifications.

The only differences in the Orchestra files in the "fix50sp2" module vs "fixlatest" are the `version` and `name` attributes in the `fixr:repository` element. 
For example, `version="FIX.5.0SP2" name="FIX.5.0SP2"`.

## Note:

* the typesafe use of customised SecurityIDSource
