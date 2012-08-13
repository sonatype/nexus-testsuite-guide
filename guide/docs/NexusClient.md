Interacting with Nexus
======================

Once you have a Nexus instance running most probably you will need to interact with it in order to make any useful test.

Examples of such interactions would be:
* managing repositories: create, update, delete, put them out of service, ...
* deploying artifacts, retrieving artifacts
* plugin specific interactions: managing capabilities, seting up staging

You will do all of this via a `NexusClient` accessible via `client()` method, as can be seen in this [example][nrpits-example-18].
To partition Nexus functionality, related functionality pieces are grouped in **subsystems** as con be seen in `resolveArtifact` method of our [example][nrpits-example-18].
Subsystems related to Nexus core functionality are directly available and those related to plugins are available only when your test project depends on the client module of that specific artifact.
In this [example][nrpits-example-19], test method `accessCapabilities` makes use of a subsystem named `Capabilities` that available because the test project depends on `org.sonatype.nexus.capabilities:nexus-capabilities-client:2.1` (see [pom][pom])


Good to know
------------

The `client` method will create you a client that will access Nexus using "admin/admin123" default admin user.

If your test needs to access Nexus using another user or anonymous user you can create your client by using the following utility methods:
* `createNexusClient( NexusBundle nexus, final String userName, final String password )`
* `createNexusClientForAnonymous( NexusBundle nexus )`

The `client` method is available only in `NexusRunningParametrizedITSupport` and `NexusRunningITSupport`.
You can use the methods above also if your test needs to create clients for other Nexus instances.

[nrpits-example-18]: ../src/test/java/org/sonatype/nexus/testsuite/guide/nrpits/NRPITSExample18IT.java
[nrpits-example-19]: ../src/test/java/org/sonatype/nexus/testsuite/guide/nrpits/NRPITSExample19IT.java
[pom]: ../pom.xml