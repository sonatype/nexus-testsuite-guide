Injected properties
-------------------

There are a set of Sisu read properties which will affect the way integration tests are working.
This properties will be read from a file named `injected-test.properties` available in classpath. You will usually place such a file in `src/test` resources directory (or `src/test/filtered-resources if your project is setup to filter resources).
This properties can be overridden using system properties with same name.

nexus.launcher.startTimeout
---------------------------

This is the time in seconds that test will wait for Nexus to boot. This time is calculated between executing the Nexus launcher (.../bin/nexus console) and then Nexus index page can be accessed.
The default value is 60 seconds.

    nexus.launcher.startTimeout=120

nexus.launcher.bundleCoordinates
--------------------------------

This is the bundle coordinates of Nexus bundle to be used (unpackaed). The value is only used when you did not specify a bundle via some other means like for example by using a parameterized test.

    nexus.launcher.bundleCoordinates=org.sonatype.nexus:nexus-oss-webapp:zip:bundle:2.0
