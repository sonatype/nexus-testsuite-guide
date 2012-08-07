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
* NexusRunningParametrizedITSupport
* NexusParametrizedITSupport
* NexusRunningITSupport
* NexusITSupport

NexusRunningParametrizedITSupport
---------------------------------

Extending this class will give you a running Nexus instance before the test starts and it will automatically shut it down when the test ends. The tests from such a class will be run multiple times, one for each Nexus version specified as parameter (and from here the Parametrized in the name).

[See details about implementing such an integration test](guide/src/test/java/org/sonatype/nexus/testsuite/guide/l01/README.md)

NexusParametrizedITSupport
--------------------------

Extending this class will give you support for managing one or more Nexus instances at your demand, so, there will be no Nexus instance running during your test by default. Based on your testing needs, you will be able to create Nexus instances, start/stop them as you need. The tests from such a class will be run multiple times, one for each Nexus version specified as parameter (and from here the Parametrized in the name).

NexusRunningITSupport
---------------------
Extending this class will give you a running Nexus instance before the test starts and it will automatically shut it down when the test ends. The tests from such a class will be run only once, against a Nexus version you specified.

NexusITSupport
--------------

Extending this class will give you support for managing one or more Nexus instances at your demand, so, there will be no Nexus instance running during your test by default. Based on your testing needs, you will be able to create Nexus instances, start/stop them as you need. The tests from such a class will be run only once, against a Nexus version you specified.

Configuring when a new Nexus instance is created
================================================

When inheriting fron `NexusRunningITSupport` or `NexusRunningParameterizedITSupport`, you ensure that a Nexus instance will be running during your test (started before and stopped after).
By default, to avoid any interference between tests, a new Nexus instance is created from scratch for each test. The downsode of this approach is that tests will run slower.
If you consider that in your tests do not interfeer, you can specify that only one Nexus instance to be created and reused in all tests. In this case a new Nexus instance is created from scrach and started before first test, and stopped after the last one.
To do so you will have to annotate the test class with `@NexusStartAndStopStrategy( NexusStartAndStopStrategy.Strategy.EACH_TEST )`.
There are two strategies:
* `EACH_TEST` - will create one instance per test class
* `EACH_METHOD` - (default) will create an instance before each test method

Resolution of Nexus version to run the tests against
====================================================

What Nexus bundle will be used during test is depending on the flavor of supprt class you are inheriting from (parametrized or not).
The resolution is perfomed only in case that you did not directly specified an bundle to be used.

NexusRunningParametrizedITSupport / NexusParametrizedITSupport
--------------------------------------------------------------

NexusRunningITSupport / NexusITSupport
--------------------------------------

In this case, the

Specify Nexus version to run the tests against
==============================================

To specify the Nexus edition/version that the intergration tests will run against, you will have to specify the Nexus bundle archive that will used.
This can be done in different ways as follows:
* bundle coordinates in an external parameters file
* bundle coordinates in test class
* bundle coordinates using an injected configuration property
* direct reference to bundle

Specifying bundle coordinates in an external paramters file
-----------------------------------------------------------

Specifying bundle coordinates in test class
-------------------------------------------

Specifying bundle coordinates using an injected configuration property
----------------------------------------------------------------------

Direct reference to bundle
--------------------------

Customising Nexus instance
==========================

Writing a Nexus plugin integration test
=======================================

FAQ
===

