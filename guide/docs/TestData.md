Accessing test data
===================

If your test needs additional data (resources) like for example some artifacts to be deployed to a Nexus repository, you should place those files in `src/test/it-resources` directory and access it via `testData()` that will give you a preconfigured `TestData.class` instance.
Lets look at this [example][nrpits-example-14] and understand how it works.

When requesting a file (or directory) as in `resolveFile( "method.txt" )` method, the `TestData` utility will look, in this order into four places as bellow, stopping on first file found:
* `it-resources/org/sonatype/nexus/testsuite/guide/nrpits/NRPITSExample14IT/fromMethod/method.txt` - look up a `method.txt` file specific to your test method
* `it-resources/org/sonatype/nexus/testsuite/guide/nrpits/NRPITSExample14IT/method.txt` - look up a `method.txt` file specific to your test class
* `it-resources/org/sonatype/nexus/testsuite/guide/nrpits/method.txt` - look up a `method.txt` file specific to your test class package
* `it-resources/method.txt` - look up a `method.txt` in root

Why all of this complication?
-----------------------------

The reasoning behind this is to allow you, if needed, to simplify use of different data when subclassing or writing a reusable test method.
Lets take a look at [example][nrpits-example-15]. In this example we configure to copy a file named `security-configuration.xml` into Nexus configuration directory.
Now, what file is copied, depends on you test method:
* when `securityEnabled` will be run the [security-configuration.xml][nrpits-example-15-se] will be copied
* when `securityDisabled` will be run the [security-configuration.xml][nrpits-example-15-sd] will be copied

[nrpits-example-14]: src/test/java/org/sonatype/nexus/testsuite/guide/nrpits/NRPITSExample14IT.java
[nrpits-example-15]: src/test/java/org/sonatype/nexus/testsuite/guide/nrpits/NRPITSExample15IT.java
[nrpits-example-15-se]: src/test/it-resources/org/sonatype/nexus/testsuite/guide/nrpits/NRPITSExample15IT/anonymousEnabled/security-configuration.xml
[nrpits-example-15-sd]: src/test/it-resources/org/sonatype/nexus/testsuite/guide/nrpits/NRPITSExample15IT/anonymousDisabled/security-configuration.xml




