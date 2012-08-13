Frequently Asked Questions
==========================

Do I have to have the Nexus bundles or plugins already in my local Maven repository?
------------------------------------------------------------------------------------

No. The bundle/plugin will be downloaded and installed automatically to you Maven local repository, in similar fashion as an usual Maven build will do.

Why My IT does not pick up the plugin built by reactor?
-------------------------------------------------------

Plugins resolution will not include the plugins built by Maven and not installed in local repository. You will have to use `mvn install`. `mvn package` will not work.

If I set a system proprty during a test I cannot see it in another test. Why?
-----------------------------------------------------------------------------

To avoid interference between tests, system properties are restored by the end of test to the state they were before the test was starting.

