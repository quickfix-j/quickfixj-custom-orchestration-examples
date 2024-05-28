# FIXT1.1 Customisation

This module demonstrates building the FIXT1.1 sources and packaging them in a jar. This may be done if it is 
necessary to customise the FIXT1.1 artifacts.

In general this is not recommended.

Please note that some of the fields are already packaged in the QuickFIX/J distribution. These redundant sources are removed 
using the `maven-antrun-plugin`. 

This is one of the ways that customisation of FIXT1.1 can be fragile and impose an additional maintenance burden.

The FIXT1.1 session messages in the are not in fact customised
