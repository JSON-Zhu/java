package com.atguigu;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * TestNIO
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/6/21 20:49
 **/
public class TestNIO {

    @Test
    public void test3() {
        ByteBuffer put = ByteBuffer.allocate(10);
        String x = "hello";
        put.put(x.getBytes());
        System.out.println(put.limit());
        System.out.println(put.position());
        System.out.println(put.capacity());
        System.out.println(":::::::::::");
        put.flip();
        System.out.println(put.limit());
        System.out.println(put.position());
        System.out.println(put.capacity());
        System.out.println("::::::::::");
        byte b = put.get();
        System.out.println(put.limit());
        System.out.println(put.position());
        System.out.println(put.capacity());
    }

    @Test
    public void test4() {
        try {

            FileInputStream fileInputStream = new FileInputStream("path1.txt");
            FileChannel channel1 = fileInputStream.getChannel();

            FileOutputStream fileOutputStream = new FileOutputStream("path.txt");
            FileChannel channel = fileOutputStream.getChannel();

            ByteBuffer allocate = ByteBuffer.allocate(10245);
            while (true) {
                allocate.clear();
                int read = channel1.read(allocate);
                if (read == -1) {
                    break;
                }
                allocate.flip();
                channel.write(allocate);
            }
            channel.close();
            channel1.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void test5() {
        try {

            FileInputStream fileInputStream = new FileInputStream("path1.txt");
            FileChannel inputStreamChannel = fileInputStream.getChannel();

            FileOutputStream fileOutputStream = new FileOutputStream("path.txt");
            FileChannel outputStreamChannel = fileOutputStream.getChannel();

//            ByteBuffer allocate = ByteBuffer.allocate(1024);
//            ByteBuffer allocate1 = ByteBuffer.allocate(4);
//            ByteBuffer[] byteBuffers={allocate,allocate1};
//            channel1.read(byteBuffers);

            inputStreamChannel.transferTo(inputStreamChannel.position(),
                    inputStreamChannel.size(),outputStreamChannel);
//            outputStreamChannel.transferFrom(inputStreamChannel,inputStreamChannel.position(),
//                    inputStreamChannel.size());
            inputStreamChannel.close();
            outputStreamChannel.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
