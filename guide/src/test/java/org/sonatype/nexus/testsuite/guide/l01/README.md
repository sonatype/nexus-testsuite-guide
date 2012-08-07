Lesson 01: Extending NexusRunningParametrizedITSupport
======================================================

Extending this class will give you a running Nexus instance before the test starts and it will automatically shut it down when the test ends. The tests from such a class will be run multiple times, one for each Nexus version specified as parameter (and from here the Parametrized in the name).

[Take a look at Lesson01IT.java](Lesson01IT.java)

