package com.test.socket;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import com.test.utils.Person;
import org.junit.Test;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.MathContext;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * D1Socket
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/18 13:12
 **/
public class D1Socket {

    public static void main(String[] args) throws Exception {

        D1Socket d1Socket = new D1Socket();
        Object clone = d1Socket.clone();


        InetAddress byName = InetAddress.getByName("127.0.0.1");

        Socket socket = new Socket(byName, 8888);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好,我是客户端姐姐".getBytes());

        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        ByteOutputStream byteOutputStream = ByteOutputStream.class.newInstance();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            byteOutputStream.write(bytes, 0, len);
        }
        System.out.println(byteOutputStream.toString());

        outputStream.close();
        socket.close();


    }

    @Test
    public void test3() throws CloneNotSupportedException {
//        BigDecimal bigDecimal = new BigDecimal(3 * 0.1, MathContext.DECIMAL32);
//        System.out.println(bigDecimal);

        int[] arr={1,2,3};
        Student p1 = new Student("zhangsan", 19,arr);

        Student p2 = p1.clone();

        p2.setAge(1);
        p1.setName("李四");
        arr[0]=5;
        p1.setArr(arr);

        System.out.println("p1=" + p1);
        System.out.println("p2=" + p2);

        short s=1;
        s+= 1;

    }

    class Student implements Cloneable{
        private String name;
        private Integer age;
        private int[] arr;

        @Override
        protected Student clone() throws CloneNotSupportedException {
            Student clone = (Student) super.clone();
            clone.arr=arr.clone();
            return clone;
        }

        public Student(String name, Integer age, int[] arr) {
            this.name = name;
            this.age = age;
            this.arr = arr;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public int[] getArr() {
            return arr;
        }

        public void setArr(int[] arr) {
            this.arr = arr;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", arr=" + Arrays.toString(arr) +
                    '}';
        }
    }

    @Test
    public void test45(){
        for (int i = 0; i < 100; i++) {
            System.out.println(new Random().nextInt(3));
        }
    }


}
