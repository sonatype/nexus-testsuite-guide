Extending NexusRunningParametrizedITSupport
===========================================

Extending this class will give you a running Nexus instance before the test starts and it will automatically shut it down when the test ends.
The tests from such a class will be run multiple times, one for each Nexus version specified as parameter (and from here the Parametrized in the name).

Lets start with the simple [example](NRPITSExample01IT.java).
In this example you are inheriting from `NexusRunningParametrizedITSupport` which will give you a running clean Nexus before each test.
The test `nexusIsRunning` is a just assering that fact.

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

What about those constructor parameters?
----------------------------------------
Read details [here](Parameters.md).

But how do I get access to running Nexus?
----------------------------------------
To get access to running Nexus you will use the `nexus()` getter. This will give you access to to `NexusBundle` that allows you to manage its lifecycle and have access to its configuration.

Can I configure the Nexus instance?
-----------------------------------
Yes. There is an configuration template method that is called before starting up Nexus you can do all sort of configuration. Take a look at [configuration explained](../nrpits/Configuration.md).
