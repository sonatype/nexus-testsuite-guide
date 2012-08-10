Creating your integration test
==============================

Nexus integration tests support is JUnit 4 based. The most easy way to get up to speed is to extend one of the four support classes, choosing the one that matches your needs:

[NexusRunningParametrizedITSupport](src/test/java/org/sonatype/nexus/testsuite/guide/nrpits/README.md)
Extending this class will give you a running Nexus instance before the test starts and it will automatically shut it down when the test ends.
The tests from such a class will be run multiple times, one for each Nexus version specified as parameter (and from here the Parametrized in the name).

[NexusParametrizedITSupport](src/test/java/org/sonatype/nexus/testsuite/guide/npits/README.md)
Extending this class will give you support for managing one or more Nexus instances at your demand, so, there will be no Nexus instance running during your test by default.
Based on your testing needs, you will be able to create Nexus instances, start/stop them as you need.
The tests from such a class will be run multiple times, one for each Nexus version specified as parameter (and from here the Parametrized in the name).

[NexusRunningITSupport](src/test/java/org/sonatype/nexus/testsuite/guide/nrits/README.md)
Extending this class will give you a running Nexus instance before the test starts and it will automatically shut it down when the test ends.
The tests from such a class will be run only once, against a Nexus version you specified.

[NexusITSupport](src/test/java/org/sonatype/nexus/testsuite/guide/nits/README.md)
Extending this class will give you support for managing one or more Nexus instances at your demand, so, there will be no Nexus instance running during your test by default.
Based on your testing needs, you will be able to create Nexus instances, start/stop them as you need.
The tests from such a class will be run only once, against a Nexus version you specified.

