package com.test.io;

import java.io.*;

/**
 * D4ObjectOutputStream
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/18 11:31
 **/
public class D4ObjectOutputStream {
    public static void main(String[] args) throws Exception {
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("person.dat"));
//
//        objectOutputStream.writeObject(new Person("zhangsan", "16"));
//
//        objectOutputStream.close();

        ObjectInputStream objectInputStream =
                new ObjectInputStream(new FileInputStream("person.dat"));
        Object object = objectInputStream.readObject();
        System.out.println(object.toString());
        objectInputStream.close();
    }

    static class Person implements Serializable {
        public static final long serialVersionUID = 12L;
        private String name;
        private String age;

        public Person(String name, String age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }
}
