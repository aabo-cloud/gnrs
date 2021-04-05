package com.bjut.fit.sse.utils;

import javax.crypto.Cipher;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class CipherUtils {

//    public static String algorithm = "RSA";

    /**
     * RSA加密
     * @param key
     * @param plainText
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(String algorithm, Key key, String plainText) throws Exception {
        // 填充加密算法
        Cipher cipher = Cipher.getInstance(algorithm);

        // 用密钥加密明文(plainText),生成密文(cipherText)
        // ENCRYPT_MODE 用于将 Cipher 初始化为加密模式的常量
        cipher.init(Cipher.ENCRYPT_MODE, key);

        // 得到加密后的字节数组
        return cipher.doFinal(plainText.getBytes("UTF-8"));
    }

    /**
     * 解密
     * @param algorithm
     * @param key
     * @param cipherText
     * @return
     * @throws Exception
     */
    public static String decrypt(String algorithm, Key key, byte[] cipherText) throws Exception {
        // 填充加密算法
        Cipher cipher = Cipher.getInstance(algorithm);
        // 设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, key);
        // 得到明文
        return new String(cipher.doFinal(cipherText));
    }

    /**
     * 生成秘钥对
     * @return
     * @throws Exception
     */
    public static KeyPair generateKeyPair() throws Exception {
        // 填充加密算法
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥长度，可选1024或2048
        keyPairGenerator.initialize(1024);
        // 生成密钥对
        return keyPairGenerator.generateKeyPair();
    }

}
