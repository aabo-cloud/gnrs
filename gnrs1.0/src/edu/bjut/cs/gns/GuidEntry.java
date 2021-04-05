package edu.bjut.cs.gns;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import edu.bjut.cs.gns.util.Md5Util;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.io.Serializable;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Random;

/**
 * 全局统一命名标识符 GUID
 */
public class GuidEntry implements Serializable {

    private static final long serialVersionUID = 1234567890L;

    private String entityName;

    private String guid;

    private RSAPublicKey publicKey;

    private RSAPrivateKey privateKey;

    public GuidEntry(String entityName) {
        this.entityName = entityName;
        generateKeyPair();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * RSA加密
     * @param key
     * @param content
     * @return
     * @throws Exception
     */
    private static String encrypt(Key key, String content) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, key);
//        String outStr = Base64.encodeBase64String(cipher.doFinal(content.getBytes("UTF-8")));
        return Base64.encode(cipher.doFinal(content.getBytes("UTF-8")));
    }

    /**
     * RSA解密
     * @param key
     * @param str
     * @return
     * @throws Exception
     */
    private static String decrypt(Key key, String str) throws Exception{
        byte[] inputByte = Base64.decode(str.getBytes("UTF-8"));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, key);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }

    /**
     * GUID自认证
     * @param x
     * @param y
     * @return
     * @throws Exception
     */
    public static boolean arbitrateGuid(GuidEntry x, GuidEntry y) throws Exception {
        Random random = new Random();
        // 生成随机数
        int n = random.nextInt(10);
        // 公钥、私钥加密后的随机数
        String kPlus = new BASE64Encoder().encode(y.publicKey.getEncoded());
        String kMinus = encrypt(y.privateKey, String.valueOf(n));

        System.out.println(Md5Util.encode(kPlus));
        System.out.println(y.guid);
        boolean flag1 = Md5Util.encode(kPlus).equals(y.guid);
        System.out.println(flag1);
        System.out.println("======================================");
        System.out.println(n);
        System.out.println(decrypt(y.publicKey, kMinus));
        boolean flag2 = decrypt(y.publicKey, kMinus).equals(String.valueOf(n));
        System.out.println(flag2);

//        System.out.println("随机数n: " + n);
//        System.out.print("[ K+，K-(n) ]: ");
//        System.out.println(kMinus);
//        System.out.println("[ " + kPlus + ", " + kMinus + "(" + n + ")]");
        return flag1 && flag2;
    }

    /**
     * 生成秘钥对
     */
    private void generateKeyPair() {
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            //公钥
            this.publicKey = (RSAPublicKey) keyPair.getPublic();
            String puk = new BASE64Encoder().encode(this.publicKey.getEncoded());
            this.guid = Md5Util.encode(puk);
//            System.out.println("公钥：" + puk);
//            System.out.println("====================================================");
            //私钥
            this.privateKey = (RSAPrivateKey) keyPair.getPrivate();
            String prk = new BASE64Encoder().encode(this.privateKey.getEncoded());
//            System.out.println("私钥：" + prk);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
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
        return "GuidEntry{" +
                "entityName='" + entityName + '\'' +
                ", guid='" + guid + '\'' +
                '}';
    }
}
