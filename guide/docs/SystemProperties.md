System Properties
=================

There are a set of system properties that can be set and which will affect the way integration tests are working.
In addition to this properties, there are a set of [injected properties][injected-properties] that can be overridden by using system properties.

it.test.log.level
-----------------

Set this property to one of TRACE/DEBUG/INFO/ERROR/NONE in order to enfoce Nexus logging level to specifid value.
By default, without setting this value, Nexus will log at INFO level.

it.parameters
-------------

Set this property to point to a parameters files that should override the parameters used by ITs. [Read][parameters-format] more about the format of parameters file.

[parameters-format]: src/test/resources/README.md
[injected-properties]: InjectedProperties.md
