package com.test.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * D1InputStreamReader
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/18 10:50
 **/

//改变打印流的流向
public class D3Systemout {

    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("hello3.txt");
        PrintStream printStream = new PrintStream(fileOutputStream, true);

        System.setOut(printStream);
        for (int i = 0; i < 50; i++) {
            System.out.print((char)i);
            if(i%10==0)
                System.out.println();
        }

        printStream.close();

    }

    public static void readString() throws Exception {

    }
}

