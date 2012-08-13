/**
 * Sonatype Nexus (TM) Open Source Version
 * Copyright (c) 2007-2012 Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://links.sonatype.com/products/nexus/oss/attributions.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License Version 1.0,
 * which accompanies this distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Sonatype Nexus (TM) Professional Version is available from Sonatype, Inc. "Sonatype" and "Sonatype Nexus" are trademarks
 * of Sonatype, Inc. Apache Maven is a trademark of the Apache Software Foundation. M2eclipse is a trademark of the
 * Eclipse Foundation. All other trademarks are the property of their respective owners.
 */
package org.sonatype.nexus.testsuite.guide.nrpits;

import java.io.File;
import java.util.Date;

import org.junit.Test;
import org.sonatype.nexus.testsuite.support.NexusRunningParametrizedITSupport;

public class NRPITSExample16IT
    extends NexusRunningParametrizedITSupport
{

    public NRPITSExample16IT( final String nexusBundleCoordinates )
    {
        super( nexusBundleCoordinates );
    }

    @Test
    public void recordInfo()
    {
        testIndex().recordInfo( "run date", new Date().toString() );
    }

    @Test
    public void recordRelativeLinks()
    {
        // record a link to nexus.xml used for this test
        testIndex().recordLink( "nexus.xml", new File( nexus().getWorkDirectory(), "conf/nexus.xml" ) );
        // record a link to some test data file
        testIndex().recordLink( "test scenario", testData().resolveFile( "test-scenario.txt" ) );
    }

    @Test
    public void recordAbsoluteLink()
    {
        // record a link to Nexus issue
        testIndex().recordLink( "testing bug", "https://issues.sonatype.org/browse/NEXUS-5178" );
    }

}
