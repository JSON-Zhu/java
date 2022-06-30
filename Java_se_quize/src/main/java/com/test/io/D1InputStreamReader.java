package com.test.io;

import sun.text.normalizer.UnicodeSet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * D1InputStreamReader
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/18 10:50
 **/

//转换流的读和写
public class D1InputStreamReader {

    public static void main(String[] args) throws Exception {

        FileInputStream fileInputStream = new FileInputStream("hello.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("hello1.txt");

        //字符流
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
         OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf-8");

        char[] chars=new char[20];
        int len=0;
        while ((len = inputStreamReader.read(chars)) != -1) {
            //输出
            System.out.println(new String(chars, 0, len));
            outputStreamWriter.write(chars,0,len);
        }
        inputStreamReader.close();
        outputStreamWriter.close();


    }

}
