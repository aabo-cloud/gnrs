package com.bjut.fit.sse.pojo;

import com.bjut.fit.sse.utils.Md5Utils;
import sun.misc.BASE64Encoder;

import java.io.Serializable;

/**
 * 名字类
 */
public class NameEntry extends RsaKey implements Serializable {

    private static final long serialVersionUID = 5440267073143994970L;

//    // id
//    private String id;

    // 可读名
    private String readableName;

    // Globally Unique Identifier
    private String guid;

    // ip地址
    private String ip;

    // 无参构造
    public NameEntry() {
        super();
//        System.out.println("NameEntry无参构造");
        try {
            this.guid = Md5Utils.encode(new BASE64Encoder().encode(this.getPublicKey().getEncoded()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public NameEntry(String guid) {
//        super();
//        try {
//            this.guid = guid;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    // 有参构造
    public NameEntry(String readableName, String ip) {
        super();
//        System.out.println("NameEntry有参构造");
        this.readableName = readableName;
        try {
            this.guid = Md5Utils.encode(new BASE64Encoder().encode(this.getPublicKey().getEncoded()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.ip = ip;
    }

//    // 满参构造（用于测试）
//    public NameEntry(String readableName, String guid, String ip) {
//        this.readableName = readableName;
//        this.guid = guid;
//        this.ip = ip;
//    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getReadableName() {
        return readableName;
    }

    public void setReadableName(String readableName) {
        this.readableName = readableName;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "NameEntry{" +
                "readableName='" + readableName + '\'' +
                ", guid='" + guid + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }

}
