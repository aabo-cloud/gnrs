package edu.bjut.cs.gns.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {
    public static void main(String[] args) throws IOException {
//
//        try {
////            InetAddress ia = InetAddress.getByName("www.pornhub.com");
//            InetAddress ia = InetAddress.getByName("www.gzlxjng.com");
//            System.out.println(ia);
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }

        Process p = Runtime.getRuntime().exec("ping " + "183.48.90.54");
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            if (line.length() != 0) {
                sb.append(line + "\r\n");
            }
        }
        System.out.println("本次指令返回的消息是：");
        System.out.println(new String(sb.toString().getBytes("gbk"), "UTF-8"));

    }
}
