Parameters file explained
=========================

The parameters files are containing [JUnit 4][junit-4] input data for your integration tests. The choses solution is to specify them in a json format.

Lets take an example:

    [
        [ "org.sonatype.nexus:nexus-oss-webapp:zip:bundle:2.0" ],
        [ "org.sonatype.nexus:nexus-oss-webapp:zip:bundle:2.1" ]
    ]

In the above example, the parameters are Nexus bundle coordinates.
There are two sets of parameters and Junit will execute all the tests for each of them.
Each line (a set) contains the parameters that will be given to the constructur of your integration test. In this case there is only one paramter, the bundle cordinates.

The constructor in you IT will be similar to:

    public FooIT( String nexusBundleCoordinates )
    {
        ...
    }

Now what if you test needs more paramters? Lets say, for example, that your test wll also need the version of Nexus.

In that case the parameters file will look like ths:

    [
        [ "2.0", "org.sonatype.nexus:nexus-oss-webapp:zip:bundle:2.0" ],
        [ "2.1", "org.sonatype.nexus:nexus-oss-webapp:zip:bundle:2.1" ]
    ]

The matching constructor of your IT will be:

    public FooIT( String nexusVersion, String nexusBundleCoordinates )
    {
        ...
    }

[junit-4] http://junit.org/junit/javadoc/4.4/org/junit/runners/Parameterized.html