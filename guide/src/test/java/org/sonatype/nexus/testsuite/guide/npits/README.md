Extending NexusParametrizedITSupport
====================================

Extending this class will give you support for managing one or more Nexus instances at your demand, so, there will be no Nexus instance running during your test by default.
Based on your testing needs, you will be able to create Nexus instances, start/stop them as you need.
The tests from such a class will be run multiple times, one for each Nexus version specified as parameter (and from here the Parametrized in the name).

Lets start with the simple [example](NPITSExample01IT.java).
In this example you are inheriting from `NexusParametrizedITSupport` which will not give you a running Nexus before each test. You will have to manually create and manage one or more Nexus instnaces.

And how do I do that?
---------------------
You will have to get you hand on an instance of `NexusBundle` You can do that by `@Inject`-ing or by using a factory. Lets look at some examples:

* [Injecting one NexusBundle](NPITSExample02IT.java) - You will use this approach when the number of Nexus instances you need in your tests is finite, as in this case one.
* [Injecting one NexusBundle](NPITSExample03IT.java) - You will use this approach when the number of Nexus instances you need in your tests is finite, as in this case two of them.
* [Injecting a factory](NPITSExample04IT.java) - You will use this approach when tou want to create an unlimited number of Nexus instances.

What about those constructor parameters?
----------------------------------------
Read details [here](../nrpits/Parameters.md).

