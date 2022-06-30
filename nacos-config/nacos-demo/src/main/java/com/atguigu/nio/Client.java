package com.atguigu.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Client
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/6/21 22:37
 **/
public class Client {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9999));
            socketChannel.configureBlocking(false);

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("zhangsan speak : ");
                String s = scanner.nextLine();
                buffer.put(("zhang san say: "+s).getBytes());
                buffer.flip();
                socketChannel.write(buffer);
                //clear cache
                buffer.clear();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
