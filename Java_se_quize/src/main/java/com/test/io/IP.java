package com.test.io;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

/**
 * IP
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/18 2:45
 **/
public class IP {
    public static void main(String[] args) throws IOException {
        InetAddress localHost = InetAddress.getByName("127.0.0.1");
        System.out.println("localHost = " + localHost);

        Socket socket = new Socket(localHost, 8899);

        OutputStream outputStream = socket.getOutputStream();

        URL x = new URL("x");
        URLConnection urlConnection = x.openConnection();

        InputStream inputStream = urlConnection.getInputStream();



    }
}
