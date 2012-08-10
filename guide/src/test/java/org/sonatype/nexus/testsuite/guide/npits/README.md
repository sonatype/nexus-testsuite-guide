Extending NexusParametrizedITSupport
====================================

Extending this class will give you support for managing one or more Nexus instances at your demand, so, there will be no Nexus instance running during your test by default.
Based on your testing needs, you will be able to create Nexus instances, start/stop them as you need.
The tests from such a class will be run multiple times, one for each Nexus version specified as parameter (and from here the Parametrized in the name).

