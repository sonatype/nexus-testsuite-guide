Extending NexusRunningParametrizedITSupport
===========================================

Extending this class will give you a running Nexus instance before the test starts and it will automatically shut it down when the test ends.
The tests from such a class will be run multiple times, one for each Nexus version specified as parameter (and from here the Parametrized in the name).

Lets start with the simplest [example](NRPITSExample01IT.java).
In this example you are inheriting from `NexusRunningParametrizedITSupport` which will give you a running clean Nexus before each test.
The test `nexusIsRunning` is a just assering that fact.

But how do I get access to running Nexus?
----------------------------------------
To get access to running Nexus you will use the `nexus()` getter. This will give you access to to `NexusBundle` that allows you to manage its lifecycle and have access to its configuration.

And how do I pass in the constructor parameter?
----------------------------------------------
The constructor parameter(s), in this case just one `nexusBundleCoordinates` is provided via JUnit `Parameterized.Parameters` support.
For a class that uses the default parameters resolution, like in this example, the parameters are loaded from a file named `paramerers.json` that will be searched in classpath. [Here is](../../../../../../../resources/parameters.json) the one used in our example. [Read more](../../../../../../../resources/README.md) about its format.

