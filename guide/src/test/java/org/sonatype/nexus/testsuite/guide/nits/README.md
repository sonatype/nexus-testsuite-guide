Extending NexusITSupport
========================

Extending this class will give you support for managing one or more Nexus instances at your demand, so, there will be no Nexus instance running during your test by default.
Based on your testing needs, you will be able to create Nexus instances, start/stop them as you need.
The tests from such a class will be run only once, against a Nexus version you specified.

Lets start with the simple [example](NITSExample01IT.java).
In this example you are inheriting from `NexusITSupport` which will not give you a running Nexus before each test. You will have to manually create and manage one or more Nexus instnaces.