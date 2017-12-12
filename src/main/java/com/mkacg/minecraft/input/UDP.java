package com.mkacg.minecraft.input;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDP extends Thread {
    @SideOnly(Side.CLIENT)
    public void run() {
        String str_send = "Hello UDPclient";
        byte[] buf = new byte[1024];
        //服务端在3000端口监听接收到的数据
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(36220);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        //接收从客户端发送过来的数据
        DatagramPacket dp_receive = new DatagramPacket(buf, 1024);
        System.out.println("server is on，waiting for client to send data......");
        boolean f = true;
        while (f) {
            //服务器端接收来自客户端的数据
            try {
                ds.receive(dp_receive);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("server received data from client：");
            String str_receive = new String(dp_receive.getData(), 0, dp_receive.getLength()) +
                    " from " + dp_receive.getAddress().getHostAddress() + ":" + dp_receive.getPort();
            System.out.println(str_receive);
            if (Minecraft.getMinecraft().player != null) {
                Minecraft.getMinecraft().player.sendChatMessage(new String(dp_receive.getData(), 0, dp_receive.getLength()));
            }
            //数据发动到客户端的3000端口
            DatagramPacket dp_send = new DatagramPacket(str_send.getBytes(), str_send.length(), dp_receive.getAddress(), 9000);
            try {
                ds.send(dp_send);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //由于dp_receive在接收了数据之后，其内部消息长度值会变为实际接收的消息的字节数，
            //所以这里要将dp_receive的内部消息长度重新置为1024
            dp_receive.setLength(1024);
        }
        ds.close();
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }
}
