package com.test.jvm;

import sun.misc.Launcher;

import javax.xml.crypto.Data;
import java.io.FileInputStream;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassLoader
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/15 23:36
 **/
public class ClassLoader {

    private Integer testx=0;

    public static void main(String[] args) {

//        ClassLoader classLoader1 = new ClassLoader();
//
//        java.lang.ClassLoader classLoader = ClassLoader.class.getClassLoader();
//
//        Collection
//
//        System.out.println("classLoader.getClass().getName() = " + classLoader.getClass().getName());
//        System.out.println("classLoader.getParent().getClass().getName() = " + classLoader.getParent().getClass().getName());
//        java.lang.ClassLoader parent = classLoader.getParent().getParent();
//        System.out.println(parent);
//
//        HashMap<String, Object> map = new HashMap<>();

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(2);
        integers.add(2);
        integers.add(2);



        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }

        System.out.println(integers.toString());
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1",2);
        map.put("11",2);
        map.put("12",2);
        map.put("13",2);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator1 = entries.iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String, Integer> next = iterator1.next();
            System.out.println( next.toString());

        }

        String x="x";
        TreeSet<String> strings = new TreeSet<>();

        new Date().compareTo(new Date());

        List<String> strings1 = new ArrayList<>();

        List<Integer> integers2 = new ArrayList<>();

        Integer[] integers1 = {1, 2, 5,};
        for (Integer integer : integers) {
            integers2.add(integer);
        }

        List<? extends ClassLoader>  listx = new ArrayList<>();
        ClassLoader classLoader = listx.get(0);

        List<? super ClassLoader>  listy = new ArrayList<>();
        Object object = listy.get(0);
        Collection<Integer> values = map.values();
        listx.forEach(System.out::println);
    }


}
class TestX extends  ClassLoader{
    public void test(List<? extends ClassLoader> list){

    }
}