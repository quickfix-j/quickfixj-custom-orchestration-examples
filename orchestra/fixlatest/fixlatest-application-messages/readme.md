# Custom Application Messages

This example builds custom application messages from FIX Orchestra.

QuickFIX/J base, core and FIXT1.1 packages can be used with custom Application message packages. 
This allows the custom messages packages to be maintained independently of the QuickFIX/J project.

Note that in this example the Maven co-ordinates for the custom artifact are different from the QuickFIX/J
`groupId` and `artifactId` . The Java package names will be the same as QuickFIX/J.
Only one implementation of the QuickFIX/J packages should be in the classpath at compilation or run time.