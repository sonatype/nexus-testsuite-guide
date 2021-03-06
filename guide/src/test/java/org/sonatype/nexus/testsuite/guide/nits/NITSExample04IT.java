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
package org.sonatype.nexus.testsuite.guide.nits;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import javax.inject.Inject;
import javax.inject.Provider;

import org.junit.Test;
import org.sonatype.nexus.bundle.launcher.NexusBundle;
import org.sonatype.nexus.testsuite.support.NexusITSupport;

public class NITSExample04IT
    extends NexusITSupport
{

    @Inject
    private Provider<NexusBundle> nexuses;

    @Test
    public void startAndStop()
    {
        final NexusBundle master = nexuses.get();
        final NexusBundle slave1 = nexuses.get();
        final NexusBundle slave2 = nexuses.get();

        assertThat( master.isRunning(), is( false ) );
        assertThat( slave1.isRunning(), is( false ) );
        assertThat( slave2.isRunning(), is( false ) );

        master.start();
        slave1.start();
        slave2.start();
        assertThat( master.isRunning(), is( true ) );
        assertThat( slave1.isRunning(), is( true ) );
        assertThat( slave2.isRunning(), is( true ) );

        master.stop();
        slave1.stop();
        slave2.stop();
        assertThat( master.isRunning(), is( false ) );
        assertThat( slave1.isRunning(), is( false ) );
        assertThat( slave2.isRunning(), is( false ) );
    }

}
