package org.skywalking.apm.agent.core.discovery;

import org.skywalking.apm.agent.core.boot.BootService;
import org.skywalking.apm.agent.core.remote.DiscoveryRestServiceClient;

/**
 * The <code>CollectorDiscoveryService</code> is responsible for start {@link DiscoveryRestServiceClient}.
 *
 * @author wusheng
 */
public class CollectorDiscoveryService implements BootService {
    @Override
    public void beforeBoot() throws Throwable {

    }

    @Override
    public void boot() throws Throwable {
        Thread collectorClientThread = new Thread(new DiscoveryRestServiceClient(), "collectorClientThread");
        collectorClientThread.setDaemon(true);
        collectorClientThread.start();
    }

    @Override
    public void afterBoot() throws Throwable {

    }
}