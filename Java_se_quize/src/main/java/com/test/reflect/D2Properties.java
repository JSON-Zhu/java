package com.test.reflect;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * D2Properties
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/18 23:12
 **/
public class D2Properties {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        //FileInputStream filterInputStream = new FileInputStream("jdbc.properties");
//        InputStream resourceAsStream =
//                D2Properties.class.getClassLoader().getResourceAsStream("hello.txt");
        ClassLoader classLoader = D2Properties.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc1.properties");

        properties.load(resourceAsStream);

        System.out.println("properties.getProperty(\"result\") = " + properties.getProperty("result"));
    }

}

