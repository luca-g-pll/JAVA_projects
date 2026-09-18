package org.example;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

public class ClientConsumer implements IDataConsumer {
    IApplicationObserver app;
    int incrementale;
    Map<InetAddress, String> doppia;

    public ClientConsumer(IApplicationObserver app) {
        this.app = app;
        this.doppia = new HashMap<InetAddress, String>();
        incrementale = 1;
    }

    @Override
    public void consumeData(byte[] data, int dataLegth, InetAddress address, int port) {
        if (!doppia.containsKey(address)) {
            app.updateFrame(doppia.get(address), data);
        } else {
            doppia.put(address, "cam" + incrementale);
            app.addCam("cam" + incrementale);
            incrementale++;
        }

    }
}
