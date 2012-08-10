System Properties
=================

There are a number of system properties that can be set and which will affect the way integration tests are working.

it.test.log.level
-----------------

Set this property to one of TRACE/DEBUG/INFO/ERROR/NONE in order to enfoce Nexus logging level to specifid value.
By default, without setting this value, Nexus will log at INFO level.

it.parameters
-------------

Set this property to point to a parameters files that should override the parameters used by ITs. [Read](src/test/java/org/sonatype/nexus/testsuite/guide/nrpits/Parameters.md) more about the format of paramters file.
