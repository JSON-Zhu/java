package com.atguigu.demo;

import com.google.common.base.Utf8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * ChannelTest
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/7/10 0:24
 **/
public class ChannelTest extends Observable {
    public static void main(String[] args) throws Exception {

        FileOutputStream fileOutputStream = new FileOutputStream("hello.txt");
        FileChannel outputStreamChannel = fileOutputStream.getChannel();
        String test = "-hello world!";
        ByteBuffer allocate = ByteBuffer.allocate(1024 * 1024 * 2);
        allocate.put(test.getBytes());
        for (int i = 0; i < 2 << 27; i++) {
            allocate.flip();
            outputStreamChannel.write(allocate);
        }
        outputStreamChannel.close();
        fileOutputStream.close();
    }

    private byte key = "\n".getBytes()[0];

    private long lineNum = 0;

    private String encode = "gb2312";

    private ReaderFileListener readerFileListener;

    public void setEncode(String encode) {
        this.encode = encode;
    }

    public void setReaderFileListener(ReaderFileListener readerFileListener) {
        this.readerFileListener = readerFileListener;
    }

    /**
     * 获取准确开始位置
     *
     * @param file
     * @param position
     * @return
     * @throws Exception
     */
    public long getStartNum(File file, long position) throws Exception {
        long startNum = position;
        FileChannel fci = new RandomAccessFile(file, "r").getChannel();
        fci.position(position);
        try {
            int cache = 1024;
            ByteBuffer allocate = ByteBuffer.allocate(cache);
            //每次读取的内容
            byte[] bytes = new byte[cache];
            //缓存
            byte[] tempBs = new byte[0];
            String line = "";
            while (fci.read(allocate) != -1) {
                int aSize = allocate.position();
                allocate.rewind();
                allocate.get(bytes);
                allocate.clear();
                byte[] newStrByte=bytes;
                //如果发现有上次未读完的缓存,则加载到当前读取的内容前面
                if(null!=tempBs){
                    int tL=tempBs.length;
                    byte[] bytes1 = new byte[aSize + tL];
                    
                }
            }
        } catch (Exception e) {

        }
        return 0;
    }
}

class ReaderFileListener {

    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(null);
        objects.add(null);
        objects.add(null);
        objects.add(null);
        
        for (Object object : objects) {
            System.out.println(object);
        }
    }

}
