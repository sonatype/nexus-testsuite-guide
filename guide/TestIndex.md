Test Index
==========

The scope of test index is to:
* give you an unique directory per test method so your tests do not colide with each other. This unique directory is also used as a home of the nexus instance(s) use dby your tests
* allow recording of additional information about your test. Examples of such info woul be links to nexus log file or the time it took to boot nexus.
* provide an overview of all integrations tests

How do I see this info?
-----------------------

You can access the generated index at `target/its/index.xml`.

Recording additional information
--------------------------------

There ar ethree type of informations you can record about your test:
* plain data - see `recordInfo` method in our [example][nrpits-example-16]
* relative links to files - see `recordRelativeLinks` method in our [example][nrpits-example-16]
* absolute links - see `recordAbsoluteLink` method in our [example][nrpits-example-16]

Using test specific directories
-------------------------------

If your test needs a directory to store some test related files you should get such a directory via `testIndex().getDirectory(<path>)`.
Test index will make sure that the returned directory will be unique per test method.
In this [example][nrpits-example-17], the `downloads` directory created for `method1` will not colide with `downloads` directory created for `method2`.

[nrpits-example-16]: src/test/java/org/sonatype/nexus/testsuite/guide/nrpits/NRPITSExample16IT.java
[nrpits-example-17]: src/test/java/org/sonatype/nexus/testsuite/guide/nrpits/NRPITSExample17IT.java
