package com.atguigu.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Client
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/6/21 22:37
 **/
public class ClientEnd {

    private Selector selector;
    private static final int port = 9999;
    private SocketChannel socketChannel;
    private String username;

    public ClientEnd() {
        try {
            //create selector
            selector = Selector.open();
            socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", port));
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
            username = socketChannel.getLocalAddress().toString().substring(1);
            System.out.println(socketChannel.getLocalAddress().toString()+"client init end!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        ClientEnd clientEnd = new ClientEnd();
        new Thread(() -> {
            while (true) {
                //System.out.println("监控回复消息中...");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clientEnd.readInfo();
            }
        }).start();

        //sent msg
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("::::::::::::");
            String s = scanner.nextLine();
            clientEnd.sendMsg(s);
        }
    }

    private void sendMsg(String s) {
        //s=username+" 说:"+s;
        try {
            socketChannel.write(ByteBuffer.wrap(s.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readInfo() {
        try {
            int select = selector.select();
            if (select > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey next = iterator.next();
                    if (next.isReadable()) {
                        //得到可以读的通道
                        //SocketChannel channel = (SocketChannel) next.channel();
                        ByteBuffer allocate = ByteBuffer.allocate(1024);
                        //channel.read(allocate);
                        socketChannel.read(allocate);
                        System.out.println(new String(allocate.array()).trim());
                    } else {
                        System.out.println("没有可以读的通道");
                    }
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
