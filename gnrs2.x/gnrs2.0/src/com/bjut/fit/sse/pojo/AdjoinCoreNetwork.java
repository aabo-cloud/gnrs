package com.bjut.fit.sse.pojo;

import java.io.Serializable;

public class AdjoinCoreNetwork implements Serializable {

    private static final long serialVersionUID = 7294986679388750807L;

    private String terminalNetworkGuid;

    private String adjoinCoreNetworkIp;

    public AdjoinCoreNetwork() {
    }

    public AdjoinCoreNetwork(String terminalNetworkGuid, String adjoinCoreNetworkIp) {
        this.terminalNetworkGuid = terminalNetworkGuid;
        this.adjoinCoreNetworkIp = adjoinCoreNetworkIp;
    }

    public String getTerminalNetworkGuid() {
        return terminalNetworkGuid;
    }

    public void setTerminalNetworkGuid(String terminalNetworkGuid) {
        this.terminalNetworkGuid = terminalNetworkGuid;
    }

    public String getAdjoinCoreNetworkIp() {
        return adjoinCoreNetworkIp;
    }

    public void setAdjoinCoreNetworkIp(String adjoinCoreNetworkIp) {
        this.adjoinCoreNetworkIp = adjoinCoreNetworkIp;
    }

    @Override
    public String toString() {
        return "AdjoinCoreNetwork{" +
                "terminalNetworkGuid='" + terminalNetworkGuid + '\'' +
                ", adjoinCoreNetworkIp='" + adjoinCoreNetworkIp + '\'' +
                '}';
    }

}
