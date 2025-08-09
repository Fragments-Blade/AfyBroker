package net.afyer.afybroker.core;

import java.io.Serializable;
import java.util.UUID;

public class BrokerPlayerInformation implements Serializable {

    private static final long serialVersionUID = -6037734488166067842L;
    public UUID uuid;
    public String name;
    public String IP;

    public BrokerPlayerInformation(UUID uuid, String name, String IP) {
        this.uuid = uuid;
        this.name = name;
        this.IP = IP;
    }

}
