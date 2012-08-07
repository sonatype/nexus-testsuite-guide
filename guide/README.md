Depend on "org.sonatype.nexus:nexus-testsuite-support"
======================================================

Using Nexus integration test support will require `org.sonatype.nexus:nexus-testsuite-support` available in class path. To do so, add the the following to your POM:

    <dependency>
      <groupId>org.sonatype.nexus</groupId>
      <artifactId>nexus-testsuite-support</artifactId>
      <version>${nexus.version}</version>
      <scope>test</scope>
    </dependency>


Creating your integration test
==============================

Nexus integration tests support is JUnit 4 based. The most easy way to get up to speed is to extend one of the four support classes, choosing the one that matches your needs:
* `NexusRunningParametrizedITSupport`
* `NexusParametrizedITSupport`
* `NexusRunningITSupport`
* `NexusITSupport`

NexusRunningParametrizedITSupport
---------------------------------

Extending this class will give you a running Nexus instance before the test starts and it will automatically shut it down when the test ends. The tests from such a class will be run multiple times, one for each Nexus version specified as parameter (and from here the Parametrized in the name).

[See details about implementing such an integration test](./src/test/java/org/sonatype/nexus/testsuite/guide/l01/README.md)

NexusParametrizedITSupport
--------------------------

Extending this class will give you support for managing one or more Nexus instances at your demand, so, there will be no Nexus instance running during your test by default. Based on your testing needs, you will be able to create Nexus instances, start/stop them as you need. The tests from such a class will be run multiple times, one for each Nexus version specified as parameter (and from here the Parametrized in the name).

NexusRunningITSupport
---------------------
Extending this class will give you a running Nexus instance before the test starts and it will automatically shut it down when the test ends. The tests from such a class will be run only once, against a Nexus version you specified.

NexusITSupport
--------------

Extending this class will give you support for managing one or more Nexus instances at your demand, so, there will be no Nexus instance running during your test by default. Based on your testing needs, you will be able to create Nexus instances, start/stop them as you need. The tests from such a class will be run only once, against a Nexus version you specified.

Specify Nexus version to run the tests against
==============================================

Customising Nexus instance
==========================

Writing a Nexus plugin integration test
=======================================
