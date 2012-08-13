Extending NexusParametrizedITSupport
====================================

Extending this class will give you support for managing one or more Nexus instances at your demand, so, there will be no Nexus instance running during your test by default.
Based on your testing needs, you will be able to create Nexus instances, start/stop them as you need.
The tests from such a class will be run multiple times, one for each Nexus version specified as parameter (and from here the Parametrized in the name).

Lets start with the simple [example][npits-example-01].
In this example you are inheriting from `NexusParametrizedITSupport` which will not give you a running Nexus before each test. You will have to manually create and manage one or more Nexus instnaces.

And how do I do that?
---------------------
You will have to get you hand on an instance of `NexusBundle` You can do that by `@Inject`-ing or by using a factory. Lets look at some examples:

* [Injecting one NexusBundle][npits-example-02] - You will use this approach when the number of Nexus instances you need in your tests is finite, as in this case one.
* [Injecting more NexusBundles][npits-example-03] - You will use this approach when the number of Nexus instances you need in your tests is finite, as in this case two of them.
* [Injecting a factory][npits-example-04] - You will use this approach when tou want to create an unlimited number of Nexus instances.

What about those constructor parameters?
----------------------------------------
Read details [here][parameters].

Can I configure the Nexus instance?
-----------------------------------
Yes. Before starting up Nexus you can do all sort of configuration via `nexus.getConfiguration()`. Take a look at [configuration explained][configuration].
[Here is an example][npits-example-05] on how change default log level of INFO to DEBUG.


[npits-example-01]: NPITSExample01IT.java
[npits-example-02]: NPITSExample02IT.java
[npits-example-03]: NPITSExample03IT.java
[npits-example-04]: NPITSExample04IT.java
[npits-example-05]: NPITSExample05IT.java
[configuration]: ../../../../../../../../../Configuration.md
[parameters]: ../../../../../../../../../Parameters.md
