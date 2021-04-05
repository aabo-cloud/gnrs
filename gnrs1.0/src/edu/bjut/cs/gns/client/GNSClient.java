package edu.bjut.cs.gns.client;

import edu.bjut.cs.gns.GuidEntry;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class GNSClient {

    public static int port = 12345;

    public static Object receiveMessage(DatagramSocket ds) throws Exception {
        byte[] container = new byte[1024 * 6];
        //DatagramPacket既可以发送包裹，又可以接收包裹
        DatagramPacket packet = new DatagramPacket(container, 0, container.length);
        ds.receive(packet);
        byte[] datas = packet.getData();

        //这里之前的源头是File,现在相当于在你程序内部定义了一个源头，这个源头是一个字节数组形式
        InputStream is = new ByteArrayInputStream(datas);//后面的操作就与InputStream基本相同了
        ObjectInputStream dis = new ObjectInputStream(new BufferedInputStream(is));

        return dis.readObject();//顺序一定要与写入时保持一致！！！！
//        if(obj instanceof GuidEntry){
//            GuidEntry guidEntryObj = (GuidEntry) obj;
//            System.out.println(guidEntryObj.getName()+"------>"+guidEntryObj.getSalary());
//        }

    }

    public static DatagramPacket sendMessage(String command) throws Exception {
        byte[] b = command.getBytes();
        int length = b.length;
        InetAddress ip = InetAddress.getByName("SoulのX1c");
        return new DatagramPacket(b, length, ip, port);
    }

    public static void main(String[] args) throws Exception {

        DatagramSocket ds = new DatagramSocket();
        String generateNewGUID = "Generate new GUID and register it in GNS";
        ds.send(sendMessage(generateNewGUID));
        ds.close();

        ds = new DatagramSocket(12346);
        while (true) {

            Object obj = receiveMessage(ds);
        //        System.out.println(obj.toString());
            if(obj instanceof GuidEntry){
                GuidEntry guidEntryObj = (GuidEntry) obj;
                System.out.println(guidEntryObj.toString());
            }

        }



//        ds.close();

    }



}
