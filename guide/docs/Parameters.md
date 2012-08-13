Parameters explained
====================

The constructor parameter(s), in this case just one `nexusBundleCoordinates` is provided via JUnit `Parameterized.Parameters` support.
For a class that uses the default parameters resolution, like in this example, the parameters are loaded from a file named `paramerers.json` that will be searched in classpath. [Here is][parameters-json] the one used in our example. [Read more][parameters-format] about its format.

Can I customize they way parameters are looked up?
--------------------------------------------------

Yes, you can. All you have to do is to provide a method that annotated with `@Parameterized.Parameters` as in the following example.

    @Parameterized.Parameters
    public static Collection<Object[]> data()
    {
        ...
    }

This method will return the sets of parameters for your IT. How you will do that, is up to your test but we provide helper methods to ease that burden. Lets see some examples:

* [Hardcoded in your IT][nrpits-example-03] - In this example your test (`nexusIsRunning`) will be run twice, for each nexus specified by ist coordinates.
* [Hardcoded in your IT][nrpits-example-04] - In this example your test (`nexusIsRunning`) will be run twice, for each nexus specified by ist coordinates. This is similar to above example, just simpler to use.
* [Using default parameters][nrpits-example-05] - A file named `parameters.json` will be loaded from classpath and the test will be run as many sets as found in that file. [Read more][parameters-format] about its format.
* [Using test specific parameters][nrpits-example-06] - A file named `<test class name>-parameters.json` (`NRPITSExample05IT-parameters.json`) will be loaded from classpath and the test will be run as many sets as found in that file. [Read more][parameters-format] about its format.
* [Using a file][nrpits-example-07] - A file, as specified, will be loaded and the test will be run as many sets as found in that file. [Read more][parameters-format] about its format.
* [Using a default system property][nrpits-example-08] - Will look up a system property named `it.parameters`. The value of that system property should point to a parameters file that will be loaded and the test will be run as many sets as found in that file. [Read more][parameters-format] about its format.
* [Using first available set of parameters][nrpits-example-09] - Will try to load parameters in the order specified. The first available one will be used. This approach serves the purpose of overriding the test specified parameters with ones specified via a system property. Any of the above explained methods can be combined/used.
* [Using all available sets of parameters][nrpits-example-10] - Will try to load parameters from all specified sources. This approach serves the purpose of aggregating parameters from divers sources. Any of the above explained methods can be combined/used.

[parameters-format]: ../src/test/resources/README.md
[parameters-json]: ../src/test/resources/parameters.json
[nrpits-example-03]: ../src/test/java/org/sonatype/nexus/testsuite/guide/nrpits/NRPITSExample03IT.java
[nrpits-example-04]: ../src/test/java/org/sonatype/nexus/testsuite/guide/nrpits/NRPITSExample04IT.java
[nrpits-example-05]: ../src/test/java/org/sonatype/nexus/testsuite/guide/nrpits/NRPITSExample05IT.java
[nrpits-example-06]: ../src/test/java/org/sonatype/nexus/testsuite/guide/nrpits/NRPITSExample06IT.java
[nrpits-example-07]: ../src/test/java/org/sonatype/nexus/testsuite/guide/nrpits/NRPITSExample07IT.java
[nrpits-example-08]: ../src/test/java/org/sonatype/nexus/testsuite/guide/nrpits/NRPITSExample08IT.java
[nrpits-example-09]: ../src/test/java/org/sonatype/nexus/testsuite/guide/nrpits/NRPITSExample09IT.java
[nrpits-example-10]: ../src/test/java/org/sonatype/nexus/testsuite/guide/nrpits/NRPITSExample10IT.java