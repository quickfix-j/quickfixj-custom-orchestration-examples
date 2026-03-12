# QuickFIX/J legacy code generator example 

## Description

This style of building custom message packages may provide the greatest compatibility with code the was compiled 
against QuickFIX/J 2.3.3 and earlier.

In this example FIX Orchestra build steps are omitted. QuickFIX/J _Fields_ and their enumerated values are generated from the 
pre-existing QuickFIX Dictionary rather than the official FIX Trading Community version of FIX Latest.

QuickFIX/J base, core and FIXT1.1 packages can be used with custom Application message packages built with the 
legacy code generator. This allows the custom messages packages to be maintained independently of the 
QuickFIX/J project.

Note that in this example the Maven co-ordinates for the custom artifact are different from the QuickFIX/J 
`groupId` and `artifactId` . The Java package names will be the same as QuickFIX/J. 
Only one implementation of the QuickFIX/J packages should be in the classpath at compilation or run time.

Legacy style builds may be useful to avoid having to change references to `static` constants based on the enumerated values
for _Fields_ in legacy QuickFIX Dictionaries; rather than FIX Orchestra `codeset`s. 
The names of constants are different in many cases.

Legacy style builds may be convenient if working with existing customised QuickFIX Dictionaries.

## Customisations
See `src/main/resourcs`

### SecurityIDSource

The Field SecurityIDSource is customised as an example. See `src/main/resourcs`

###  QuoteMsgID 

The Field QuoteMsgID is added to Execution Report as an example. See `src/main/resourcs`

## Build

### Optionally Skip javadoc

The build runs a little faster if one skips javadoc generation

`mvn clean install -Dmaven.javadoc.skip=true`