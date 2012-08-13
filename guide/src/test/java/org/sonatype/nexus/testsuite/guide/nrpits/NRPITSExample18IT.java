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
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

import org.junit.Test;
import org.sonatype.nexus.client.core.NexusStatus;
import org.sonatype.nexus.client.core.subsystem.artifact.ArtifactMaven;
import org.sonatype.nexus.client.core.subsystem.artifact.ResolveRequest;
import org.sonatype.nexus.client.core.subsystem.artifact.ResolveResponse;
import org.sonatype.nexus.testsuite.support.NexusRunningParametrizedITSupport;

public class NRPITSExample18IT
    extends NexusRunningParametrizedITSupport
{

    public NRPITSExample18IT( final String nexusBundleCoordinates )
    {
        super( nexusBundleCoordinates );
    }

    @Test
    public void nexusStatus()
    {
        final NexusStatus nexusStatus = client().getNexusStatus();
        assertThat( nexusStatus.getEditionLong(), is( notNullValue() ) );
    }

    @Test
    public void resolveArtifact()
    {
        final ResolveResponse resolved = client().getSubsystem( ArtifactMaven.class ).resolve(
            new ResolveRequest( "releases", "foo", "bar", "1.0" )
        );
        // we did not deployed such an artifact before so it should not exist
        assertThat( resolved, is( nullValue() ) );
    }

}
