# Customising FIX using QuickFIX/J's legacy codegen
 
The example is based on FIX5.0SP2. It demonstrates customisation of the Field SecurityIDSource and the 
addition of QuoteMsgID to Execution Report.

The custom message dependencies are built independently of the QuickFIX/J project, and the custom messages can be
 used with the standard QuickFIX/J base, core and FIXT1.1 packages.

You might use this approach for consistency with legacy QucikFIX/J builds. 
Enumeration names, for example, will be the same as in the legacy QuickFIX/J versioned releases. 
Existing custom QuickFIX dictionaries can be used with this style of build.

Customisation by building only message dependencies can ease maintenance. 

You need only update the QuickFIX/J base, core and FIXT1.1 dependencies to the latest versions while 
maintaining your custom messages builds independently. 
You can maintain your custom messages independently of the QuickFIX/J project and its release cycle.

## Note: 

* the typesafe use of customised SecurityIDSource
* the addition of QuoteMsgID to the Execution Report message.

## References
### This module
* [Application Message readme](./legacy-codegen-fix50sp2-application-messages/readme.md)
