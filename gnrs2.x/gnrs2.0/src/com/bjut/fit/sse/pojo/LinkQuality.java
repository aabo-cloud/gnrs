package com.bjut.fit.sse.pojo;

import java.io.Serializable;

/**
 * 连接质量
 */
public class LinkQuality implements Serializable {

    private static final long serialVersionUID = -3120535450130176934L;

    private String startIp;

    private String endIp;

    private Double qualityMetric;

    public LinkQuality() {
    }

    public LinkQuality(String startIp, String endIp, Double qualityMetric) {
        this.startIp = startIp;
        this.endIp = endIp;
        this.qualityMetric = qualityMetric;
    }

    public String getStartIp() {
        return startIp;
    }

    public void setStartIp(String startIp) {
        this.startIp = startIp;
    }

    public String getEndIp() {
        return endIp;
    }

    public void setEndIp(String endIp) {
        this.endIp = endIp;
    }

    public Double getQualityMetric() {
        return qualityMetric;
    }

    public void setQualityMetric(Double qualityMetric) {
        this.qualityMetric = qualityMetric;
    }

    @Override
    public String toString() {
        return "LinkQuality{" +
                "startIp='" + startIp + '\'' +
                ", endIp='" + endIp + '\'' +
                ", qualityMetric=" + qualityMetric +
                '}';
    }
}
