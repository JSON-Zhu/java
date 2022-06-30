package com.atguigu.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Server
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/6/21 22:04
 **/
public class Server {
    public static void main(String[] args) {
        try {
            System.out.println("server start!");
            ServerSocketChannel ssChannel = ServerSocketChannel.open();
            //non-blocking
            ssChannel.configureBlocking(false);
            //binding-port
            ssChannel.bind(new InetSocketAddress(9999));
            //selector
            Selector selector = Selector.open();
            //register channel to selector
            ssChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (selector.select() > 0) {
                //iterate selected keys
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    //accept
                    if (selectionKey.isAcceptable()) {
                        SocketChannel socketChannel = ssChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    }
                    //readable
                    if (selectionKey.isReadable()) {
                        SocketChannel channel = (SocketChannel) selectionKey.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int len;
                        while ((len = channel.read(buffer)) >0) {
                            buffer.flip();
                            System.out.println(new String(buffer.array(), 0, len));
                            buffer.clear();
                        }
                    }
                    //remove key
                    iterator.remove();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
