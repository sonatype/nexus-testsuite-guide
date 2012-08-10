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
-----------------------------------------------
The constructor parameter(s), in this case just one `nexusBundleCoordinates` is provided via JUnit `Parameterized.Parameters` support.
For a class that uses the default parameters resolution, like in this example, the parameters are loaded from a file named `paramerers.json` that will be searched in classpath. [Here is](../../../../../../../resources/parameters.json) the one used in our example. [Read more][parameters] about its format.

Can I customize they way parameters are looked up?
--------------------------------------------------

Yes, you can. All you have to do is to provide a method that annotated with `@Parameterized.Parameters` as in the following example.

    @Parameterized.Parameters
    public static Collection<Object[]> data()
    {
        ...
    }

This method will return the sets of parameters for your IT. How you will do that, is up to your test but we provide helper methods to ease that burden. Lets see some examples:

* [Hardcoded in your IT](NRPITSExample03IT.java) - In this example your test (`nexusIsRunning`) will be run twice, for each nexus specified by ist coordinates.
* [Hardcoded in your IT](NRPITSExample04IT.java) - In this example your test (`nexusIsRunning`) will be run twice, for each nexus specified by ist coordinates. This is similar to above example, just simpler to use.
* [Using default parameters](NRPITSExample05IT.java) - A file named `parameters.json` will be loaded from classpath and the test will be run as many sets as found in that file. [Read more][parameters] about its format.
* [Using test specific parameters](NRPITSExample06IT.java) - A file named `<test class name>-parameters.json` (`NRPITSExample05IT-parameters.json`) will be loaded from classpath and the test will be run as many sets as found in that file. [Read more][parameters] about its format.
* [Using a file](NRPITSExample07IT.java) - A file, as specified, will be loaded and the test will be run as many sets as found in that file. [Read more][parameters] about its format.
* [Using a default system property](NRPITSExample08IT.java) - Will look up a system property named `NexusItSupport.parameters`. The value of that system property should point to a parameters file that will be loaded and the test will be run as many sets as found in that file. [Read more][parameters] about its format.
* [Using first available set of parameters](NRPITSExample09IT.java) - Will try to load parameters in the order specified. The first available one will be used. This approach serves the purpose of overriding the test specified parameters with ones specified via a system property. Any of the above explained methods can be combined/used.
* [Using all available sets of parameters](NRPITSExample10IT.java) - Will try to load parameters from all specified sources. This approach serves the purpose of aggregating parameters from divers sources. Any of the above explained methods can be combined/used.

Configuring when a new Nexus instance is created
------------------------------------------------

When inheriting fron `NexusRunningParameterizedITSupport`, you ensure that a Nexus instance will be running during your test (started before and stopped after).
By default, to avoid any interference between tests, a new Nexus instance is created from scratch for each test. The downsode of this approach is that tests will run slower.
If you consider that in your tests do not interfeer, you can specify that only one Nexus instance to be created and reused in all tests. In this case a new Nexus instance is created from scrach and started before first test, and stopped after the last one.
To do so you will have to annotate the test class with `@NexusStartAndStopStrategy( NexusStartAndStopStrategy.Strategy.EACH_TEST )`.
There are two strategies:
* `EACH_TEST` - will create one instance per test class
* `EACH_METHOD` - (default) will create an instance before each test method

Here is an [example](NRPITSExample02IT.java) of starting Nexus only once per class. Note the annotation on class level.

[parameters]: ../../../../../../../resources/README.md
