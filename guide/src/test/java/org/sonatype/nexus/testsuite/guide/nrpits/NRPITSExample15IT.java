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

import static org.sonatype.sisu.filetasks.builder.FileRef.file;
import static org.sonatype.sisu.filetasks.builder.FileRef.path;

import javax.inject.Inject;

import org.junit.Test;
import org.sonatype.nexus.bundle.launcher.NexusBundleConfiguration;
import org.sonatype.nexus.testsuite.support.NexusRunningParametrizedITSupport;
import org.sonatype.sisu.filetasks.FileTaskBuilder;

public class NRPITSExample15IT
    extends NexusRunningParametrizedITSupport
{

    @Inject
    private FileTaskBuilder overlays;

    public NRPITSExample15IT( final String nexusBundleCoordinates )
    {
        super( nexusBundleCoordinates );
    }

    @Test
    public void anonymousEnabled()
    {
        // do something to test that anonymous access is enabled
    }

    @Test
    public void anonymousDisabled()
    {
        // do something to test that anonymous access is disabled
    }

    @Override
    protected NexusBundleConfiguration configureNexus( final NexusBundleConfiguration configuration )
    {
        return configuration
            .addOverlays(
                overlays.copy()
                    .file( file( testData().resolveFile( "security-configuration.xml" ) ) )
                    .to().directory( path( "sonatype-work/nexus/conf" ) )
            );
    }

}
