package com.test.concurrent.list;

import com.sun.jmx.remote.internal.ArrayQueue;
import sun.misc.Unsafe;

import java.util.*;
import java.util.concurrent.*;

/**
 * D01ListConcurrent
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/6 21:09
 **/
public class D01ListConcurrent {

    final class Test2{
        public   Integer x=0 ;
        public   String name="";

    }

    public final Integer height=0;

    private  List<String> list = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {

        D01ListConcurrent d01ListConcurrent = new D01ListConcurrent();

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        CopyOnWriteArraySet<Object> copyOnWriteArraySet = new CopyOnWriteArraySet<>();

        Unsafe unsafe = Unsafe.getUnsafe();



    }
    public void test(){



        Person person = new Person();
        Person2 person2 = new Person2();

        Person3 person3 = new Person3(3);
        Integer age3 = person3.age3;

        Integer x = new Person().x;

    }

    class Person{
        Integer x =9;
        public void test(){

        }

    }

    private class Person2{
        private Integer age;
    }

    static class Person3{
        private static Integer age3=8;

        public Person3(Integer age3) {
            this.age3 = age3;
        }
    }

    class  x extends D01ListConcurrent{
        @Override
        public void test() {
            D01ListConcurrent d01ListConcurrent = new D01ListConcurrent();
            Person2 person2 = new Person2();
            Integer age = person2.age;

        }
    }

}

