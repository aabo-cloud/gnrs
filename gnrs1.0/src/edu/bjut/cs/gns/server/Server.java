package edu.bjut.cs.gns.server;

import edu.bjut.cs.gns.GuidEntry;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {

    private static int port = 12345;


    public static DatagramPacket receiveMessage(DatagramSocket ds) throws Exception {

        byte[] b = new byte[1024];
        int length = b.length;

        DatagramPacket dp = new DatagramPacket(b, length);
        ds.receive(dp);

//        String ip = dp.getAddress().getHostAddress();
//        byte[] data = dp.getData();
//        int len = dp.getLength();
//        String str = new String(data, 0, len);

//        System.out.println(ip + " : " + str);
        return dp;
    }

    public static void sendMessage(DatagramSocket ds, InetAddress ip, int port, Object guidEntry) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 用这个流放进去数据给baos，dos装数据的同时，数据也进去了baos
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));
        oos.writeObject(guidEntry);
        oos.flush();
        byte[] datas = baos.toByteArray();
        DatagramPacket dp = new DatagramPacket(datas, datas.length, ip, port);
        ds.send(dp);
    }

    public static void main(String[] args) throws Exception {

        DatagramSocket ds = new DatagramSocket(port);

        while (true) {

            DatagramPacket clientMessage = receiveMessage(ds);
            System.out.println(clientMessage.toString());
            // 客户端的地址
            InetAddress ia = clientMessage.getAddress();

            byte[] data = clientMessage.getData();
            int len = clientMessage.getLength();
            // 数据
            String str = new String(data, 0, len);
            if (str.equals("Generate new GUID and register it in GNS")) {
                GuidEntry X = new GuidEntry(ia.getHostAddress());
                System.out.println(X.toString());
                sendMessage(ds, ia, 12346, X);

            }


        }

//        ds.close();

    }


}
