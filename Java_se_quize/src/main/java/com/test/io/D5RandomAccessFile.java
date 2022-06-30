package com.test.io;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * D4ObjectOutputStream
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/18 11:31
 **/
public class D5RandomAccessFile {

    public D5RandomAccessFile() {
    }

    public static void main(String[] args) throws Exception {
//        //RandomAccessFile读和写
//        RandomAccessFile r = new RandomAccessFile("hello.txt", "r");
//        RandomAccessFile rw = new RandomAccessFile("job.txt", "rw");
//
//        byte[] bytes = new byte[1024];
//        int len;
//        while ((len = r.read(bytes)) != -1) {
//            rw.write(bytes,0,len);
//        }
//        rw.close();
//        r.close();

        socketServer();



    }
    public static void socketServer() throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();

        ByteOutputStream byteOutputStream = ByteOutputStream.class.newInstance();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            byteOutputStream.write(bytes,0,len);
        }
        System.out.println(byteOutputStream.toString());

        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("服务器哥哥收到了".getBytes());

        byteOutputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }

    public static void randomFile() throws IOException {
        RandomAccessFile rw = new RandomAccessFile("job.txt", "rw");

        //备份3之后的数据
        rw.seek(3);
        StringBuilder stringBuilder = new StringBuilder((int) new File("job.txt").length());
        byte[] bytes = new byte[1024];
        int len;
        while ((len = rw.read(bytes)) != -1) {
            stringBuilder.append(new String(bytes,0,len));
        }


        //重回3开始写数据
        rw.seek(3);
        rw.write("xyz".getBytes());
        rw.write(stringBuilder.toString().getBytes());
        rw.close();
    }

}
