package com.conn;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.util.*;

/**
 * GenericTest
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/6/9 18:38
 **/
public class GenericTest {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("test");
        String str=strings.get(0);

        ArrayList<? super Number> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(3.0f);
        numbers.add(3d);
        numbers.stream().forEach(System.out::println);
        numbers.add(null);

    }
    public static <T> T test(List<? extends T> list){

        return (T) list;

    }


    public static <T> T test2(List<? super T> list){
        return (T) list;
    }

    public final void test3(){

    }

    public  void test4() throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        Selector open = Selector.open();

    }


}

class X extends GenericTest{

}
