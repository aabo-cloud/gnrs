package com.bjut.fit.sse.pojo;

import com.bjut.fit.sse.utils.CipherUtils;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class RsaKey {

    // rsa公钥
    private RSAPublicKey publicKey;

    // rsa私钥
    private RSAPrivateKey privateKey;

    // 无参构造
    public RsaKey() {
        try {
            KeyPair keyPair = CipherUtils.generateKeyPair();
            this.publicKey = (RSAPublicKey) keyPair.getPublic();
            this.privateKey = (RSAPrivateKey) keyPair.getPrivate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RSAPublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(RSAPublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public RSAPrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(RSAPrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    @Override
    public String toString() {
        return "RsaKey{" +
                "publicKey=" + publicKey +
                ", privateKey=" + privateKey +
                '}';
    }

}
