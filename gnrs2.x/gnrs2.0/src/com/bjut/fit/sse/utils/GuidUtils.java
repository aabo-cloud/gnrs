package com.bjut.fit.sse.utils;

import com.bjut.fit.sse.pojo.NameEntry;
import sun.misc.BASE64Encoder;

import java.util.Random;

public class GuidUtils {

    /**
     * 名字认证
     * @param y
     * @return
     * @throws Exception
     */
    public static boolean certifyGuid(NameEntry y) throws Exception {
        Random random = new Random();
        // 随机数范围多少还要考虑
        int n = random.nextInt(10);
        String kPlus = new BASE64Encoder().encode(y.getPublicKey().getEncoded());
        byte[] kMinus = CipherUtils.encrypt("RSA", y.getPrivateKey(), n + "");

        return Md5Utils.encode(kPlus).equals(y.getGuid()) && CipherUtils.decrypt("RSA", y.getPublicKey(), kMinus).equals(n + "");
    }

}
