package com.test.io;

import java.io.*;

/**
 * D1InputStreamReader
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/18 10:50
 **/

//转换流的读和写
public class D2Systemin {

    public static void main1(String[] args) throws Exception {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        for (; ; ) {
            String s = bufferedReader.readLine();
            if ("e".equals(s)) {
                System.out.println("程序结束");
                break;
            }
            System.out.println(s.toUpperCase());

        }
    }

    public static void main(String[] args) throws Exception {
        String s = D2Systemin.readString();
        System.out.println("输入的s = " + s);
    }

    public static String readString() throws Exception {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String s = "";
        s = bufferedReader.readLine();

        return s;
    }
}

