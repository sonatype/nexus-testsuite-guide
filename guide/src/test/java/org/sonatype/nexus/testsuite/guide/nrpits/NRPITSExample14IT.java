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

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.sonatype.nexus.testsuite.support.NexusRunningParametrizedITSupport;
import org.sonatype.sisu.litmus.testsupport.hamcrest.FileMatchers;

public class NRPITSExample14IT
    extends NexusRunningParametrizedITSupport
{

    public NRPITSExample14IT( final String nexusBundleCoordinates )
    {
        super( nexusBundleCoordinates );
    }

    @Test
    public void fromMethod()
    {
        assertThat( testData().resolveFile( "method.txt" ), FileMatchers.containsOnly(
            "it-resources/org/sonatype/nexus/testsuite/guide/nrpits/NRPITSExample14IT/fromMethod"
        ) );
    }

    @Test
    public void fromClass()
    {
        assertThat( testData().resolveFile( "class.txt" ), FileMatchers.containsOnly(
            "it-resources/org/sonatype/nexus/testsuite/guide/nrpits/NRPITSExample14IT"
        ) );
    }

    @Test
    public void fromPackage()
    {
        assertThat( testData().resolveFile( "package.txt" ), FileMatchers.containsOnly(
            "it-resources/org/sonatype/nexus/testsuite/guide/nrpits"
        ) );
    }

    @Test
    public void fromRoot()
    {
        assertThat( testData().resolveFile( "root.txt" ), FileMatchers.containsOnly(
            "it-resources"
        ) );
    }

}
