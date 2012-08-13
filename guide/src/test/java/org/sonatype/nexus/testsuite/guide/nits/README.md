Extending NexusITSupport
========================

Extending this class will give you support for managing one or more Nexus instances at your demand, so, there will be no Nexus instance running during your test by default.
Based on your testing needs, you will be able to create Nexus instances, start/stop them as you need.
The tests from such a class will be run only once, against a Nexus version you specified.

Lets start with the simple [example](NITSExample01IT.java).
In this example you are inheriting from `NexusITSupport` which will not give you a running Nexus before each test. You will have to manually create and manage one or more Nexus instnaces.

And how do I do that?
---------------------
You will have to get you hand on an instance of `NexusBundle` You can do that by `@Inject`-ing or by using a factory. Lets look at some examples:

* [Injecting one NexusBundle](NITSExample02IT.java) - You will use this approach when the number of Nexus instances you need in your tests is finite, as in this case one.
* [Injecting more NexusBundles](NITSExample03IT.java) - You will use this approach when the number of Nexus instances you need in your tests is finite, as in this case two of them.
* [Injecting a factory](NITSExample04IT.java) - You will use this approach when tou want to create an unlimited number of Nexus instances.

Can I configure the Nexus instance?
-----------------------------------
Yes. Before starting up Nexus you can do all sort of configuration via `nexus.getConfiguration()`. Take a look at [configuration explained](../../../../../../../../../Configuration.md).
[Here is an example](NITSExample05IT.java) on how change default log level of INFO to DEBUG.
