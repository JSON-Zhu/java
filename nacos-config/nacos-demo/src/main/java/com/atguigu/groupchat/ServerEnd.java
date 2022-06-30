package com.atguigu.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ServerEnd
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/6/21 23:20
 **/
public class ServerEnd {
    private final static ConcurrentHashMap<String, SocketChannel> map = new ConcurrentHashMap();
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private static final int port = 9999;
    private int i = 0;
    private int j = 0;

    //init
    public ServerEnd() {
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            selector = Selector.open();
            serverSocketChannel.bind(new InetSocketAddress(port));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServerEnd serverEnd = new ServerEnd();
        serverEnd.listen();
    }

    /**
     * listen msg from client
     */
    private void listen() {
        System.out.println("listen thread: " + Thread.currentThread().getName());
        try {
            while (selector.select() > 0) {
                System.out.println("第一轮事件处理");
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey next = iterator.next();
                    if (next.isAcceptable()) {
                        //接收客户端连接,注册到selector
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        System.out.println(socketChannel.getRemoteAddress() + "上线了.");
                        String key = socketChannel.getRemoteAddress().toString().split(":")[1];
                        map.put(key, socketChannel);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    } else if (next.isReadable()) {
                        readMsg(next);
                    }
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取客户端消息
     *
     * @param next
     */
    private void readMsg(SelectionKey next) {
        System.out.println("readMsg thread: " + Thread.currentThread().getName());
        SocketChannel channel = null;
        try {
            channel = (SocketChannel) next.channel();
            ByteBuffer allocate = ByteBuffer.allocate(1024);
            int read = channel.read(allocate);
            if (read > 0) {
                allocate.flip();
                String msg = new String(allocate.array(), 0, allocate.remaining());// read->remaining

                //放入map
                //map.put(i, channel);

                System.out.println(channel.getRemoteAddress() + ":客户端发来的消息" + msg);
                //发送至其他客户端,群发或私发
                if (msg.startsWith("-")) {
                    sendToClient(msg, channel);
                } else {
                    sendToTheClient(msg, channel);
                }
                allocate.clear();
            }
        } catch (Exception e) {
            try {
                System.out.println(channel.getRemoteAddress() + " 离线了..");
                //取消注册
                next.cancel();
                //关闭通道
                channel.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void sendToTheClient(String msg, SocketChannel channel) {
        System.out.println("发送给指定客户端");
        String destChannelKey = msg.split("-")[0];
        SocketChannel socketChannel = map.get(destChannelKey);
        try {
            ByteBuffer wrap = ByteBuffer.wrap((channel.getRemoteAddress().toString() + "说:"
                    + msg.split("-")[1]).getBytes());
            socketChannel.write(wrap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendToClient(String msg, SocketChannel channel) throws IOException {
        System.out.println("send to other clients");
        System.out.println("服务器转发数据给客户端线程: " + Thread.currentThread().getName());
        Set<SelectionKey> selectionKeys = selector.keys();
        for (SelectionKey selectionKey : selectionKeys) {
            //serverChannel也注册进了selector,需要排除
            Channel channel1 = selectionKey.channel();
            if (channel1 instanceof SocketChannel
                    && !(channel1 == channel)
            ) {
                //SocketChannel socketChannel = (SocketChannel) channel1;
                ByteBuffer wrap = ByteBuffer.wrap(msg.getBytes());
                ((SocketChannel) channel1).write(wrap);
                //SocketChannel socketChannel = map.get(i);
                //socketChannel.write(wrap);
            }
        }
//        for (SelectionKey selectionKey : selector.selectedKeys()) {
//
//        }
    }

}
