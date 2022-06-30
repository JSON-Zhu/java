package com.test.io;


import java.io.*;
import java.nio.channels.Channel;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * OtherStream
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/17 21:50
 **/
public class OtherStream implements Serializable {

    public static void main(String[] args) {
        int a=10;
        int b=10;
        method(a,b);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    private static void method(int a, int b) {
        PrintStream printStream = new MyStream(System.out);
        System.setOut(printStream);
    }

    static class MyStream extends PrintStream{

        public MyStream(OutputStream out) {
            super(out);
        }

        @Override
        public void print(String s) {
            if(s.startsWith("a")){
                super.print("a=100");
            }
            if(s.startsWith("b")){
                super.print("b=100");
            }
        }
    }

}
