package com.bjut.fit.sse.dao;

import com.bjut.fit.sse.pojo.LinkQuality;

import java.util.List;

public interface LinkQualityDao {

    /**
     * 得到所有邻接网络的链路质量
     * @param startIp
     * @return
     */
    public List<LinkQuality> queryLinkQualitiesByStartIp(String startIp);

    /**
     * 得到某条链路的质量
     * @param startIp
     * @param endIp
     * @return
     */
    public Double queryLinkQualityByStartIpAndEndIp(String startIp, String endIp);

}
