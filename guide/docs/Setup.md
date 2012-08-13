Setting up your test project
============================

Using Nexus integration test support will require `org.sonatype.nexus:nexus-testsuite-support` available in class path. To do so, add the the following to your POM:

    <dependency>
      <groupId>org.sonatype.nexus</groupId>
      <artifactId>nexus-testsuite-support</artifactId>
      <version>${nexus.version}</version>
      <scope>test</scope>
    </dependency>


