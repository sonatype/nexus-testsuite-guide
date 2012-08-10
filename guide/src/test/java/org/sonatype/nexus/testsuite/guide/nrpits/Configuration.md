Configuration explained
=======================

A Nexus instance to be started can be configured in a number of ways depending on your testing needs.

This will [example](NRPITSExample11IT.java) some common configurations.


Adding Nexus plugins
--------------------

Configure log level
-------------------
In case that you will want to make Nexus log at some other level then default (INFO), you can do so via `setLogLevel()`.

Configure startup timeout
-------------------------
By default, after Nexus instance is started, it will wait for 1 minute for Nexus to boot (to be able to access its status page).
This timeout can be changed via `setStartTimeout()`.

Advanced configuration
======================

The following configuration options are not a very common case.


Overlays
--------
Overlays are ways to perform additional tasks on the bundle prepared for Nexus. As for example copying additional files, changing some files, ...
In this [example](NRPITSExample12IT.java), we will pre-populate a repository with some artifacts.

Starting Nexus in debug mode
----------------------------
In cases that you want to remotly debug Nexus instance you can enable it via `enableDebbuging()`.
This will take as arguments, the port to connect to and if Nexus should wait for a debugger to connect before it starts.
In this [example](NRPITSExample13IT.java), debugging will be available on port `5005`, whithout waiting for debugger to connect.