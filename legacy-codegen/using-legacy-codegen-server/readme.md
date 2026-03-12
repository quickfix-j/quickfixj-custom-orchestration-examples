# Example of using legacy codegen
 
The example is based on FIX5.0SP2. It demonstrates customisation of the Field SecurityIDSource and the 
addition of QuoteMsgID to Execution Report.

The custom messages are built independently of the QuickFIX/J project, and the custom messages can be
 used with the standard QuickFIX/J base, core and FIXT1.1 packages.

You might use this approach for consistency with legacy QucikFIX/J builds. 
Enumeration names, for example, will be the same as in the legacy QuickFIX/J versions. 
Existing custom QuickFIX dictionaries can be used with this style of build.

You can more easily update the QuickFIX/J base, core and FIXT1.1 packages to the latest versions while 
maintaining your custom messages builds independently. 
You can maintain your custom messages independently of the QuickFIX/J project and its release cycle.

## Note: 

* the typesafe use of customised SecurityIDSource and the contrived addition of QuoteMsgID to the Execution Report message.
* the use of the QuickFIX/J base, core and FIXT1.1 package dependencies from the standard build of QuickFIX/J alongside 
the customised messages package.
 


