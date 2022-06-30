package com.atguigu.groupchat;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class BigEndian {

    public static void main(String[] args) {

        System.out.println(ByteOrder.nativeOrder());

        System.out.println(":::::::::::");

        int x = 0x01020304;
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[4]);
        byteBuffer.asIntBuffer().put(x);
        String before = Arrays.toString(byteBuffer.array());
        System.out.println("默认字节序：" + byteBuffer.order().toString() + "," + "内存数据：" + before);

        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.asIntBuffer().put(x);
        String after = Arrays.toString(byteBuffer.array());
        System.out.println("小端字节序：" + byteBuffer.order().toString() + "," + "内存数据：" + after);
    }
}
