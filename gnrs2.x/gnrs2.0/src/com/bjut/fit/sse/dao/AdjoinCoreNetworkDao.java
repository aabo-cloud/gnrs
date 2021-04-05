package com.bjut.fit.sse.dao;

public interface AdjoinCoreNetworkDao {

    /**
     * 根据 guid 查找该网络的邻接核心网络
     * @param guid
     * @return
     */
    public String[] queryAdjoinCoreNetworkByGuid(String guid);

}
