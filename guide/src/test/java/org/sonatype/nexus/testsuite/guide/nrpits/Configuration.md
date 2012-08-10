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
