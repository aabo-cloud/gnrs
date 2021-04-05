package com.bjut.fit.sse.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5 加密工具类
 *
 * @author mazaiting
 */
public class Md5Utils {

    /**
     * MD5 加密 生成32位MD5码
     *
     * @param source 需要加密的字符串
     * @return 32位MD5码
     */
    public static String encode(String source) throws Exception {
        try {
            // 获得MD5 消息摘要
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            // 获得指定编码的字节数据
            byte[] sourceBytes = source.getBytes("UTF-8");
            // 指定的字节数组对摘要执行最终更新
            byte[] digestBytes = messageDigest.digest(sourceBytes);
            StringBuffer hexValue = new StringBuffer();

            for (int i = 0; i < digestBytes.length; i++) {
                int val = (digestBytes[i] & 0xff);
                if (val < 16) {
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }

            return hexValue.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;// 获得MD5 消息摘要异常
        } catch (UnsupportedEncodingException e) {
            return null;// 获得指定编码的字节数据异常
        }
    }

}