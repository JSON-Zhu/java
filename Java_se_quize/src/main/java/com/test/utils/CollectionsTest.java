package com.test.utils;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * CollectionsTest
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/22 20:02
 **/
public class CollectionsTest {

    @Test
    public void test() {

        ArrayList<Object> objects = new ArrayList<>();
        ArrayList<Object> objects2 = new ArrayList<>();
        objects.add(123);
        objects.add(456);
        objects2.add(123);
        objects2.add(789);
        objects2.add(456);

        System.out.println("objects.contains(123) = " + objects.contains(123));

        System.out.println(objects2.retainAll(objects));
        System.out.println("objects2 = " + objects2);

        System.out.println("objects2.equals(objects) = " + objects2.equals(objects));

    }

    @Test
    public void test02() {
        //HashSet<String> strings = new HashSet<>();
        //HashSet<String> strings2 = new HashSet<>();

        ArrayList<Object> strings = new ArrayList<>();
        ArrayList<Object> strings2 = new ArrayList<>();


        List<String> list = Arrays.asList("1", "2", "4");

        strings.add("2");
        strings.add("3");

        strings.remove("2");
        System.out.println("strings.toString() = " + strings.toString());

        //System.out.println(strings);

//        for (int i = 0; i < 100; i++) {
//
//            System.out.println((int) (Math.random() * 100));
//            System.out.println(new Random().nextInt(10));
//
//        }

//        System.out.println(Math.ceil(-11.9));
//        double floor = Math.floor(-11.2);
//        System.out.println("floor = " + floor);

    }

    @Test
    public void test04() {
        int a = 5;//0101
        int b = 6;//0110
        //0111
        //0110
        b |= a;
        System.out.println(b);
    }

    @Test
    public void test05() throws ExecutionException, InterruptedException {
        Consumer<String> consumer = (o1) -> {
            System.out.println(o1);
        };
        consumer.accept("zhangsan");
        Supplier<String> stringSupplier = () -> "我是supplier";
        System.out.println(stringSupplier.get());

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("supply async");
            return "test";
        });
        System.out.println("future.get() = " + future.get());

        Consumer<String> consumer1=System.out::println;
        consumer1.accept("李四");
        System.out.println(Math.round(4.8));

    }

    @Test
    public void test2(){
//        Supplier<Person> supplier= () -> new Person();
////        supplier.get();
        Function<Integer,String[]> function= integer -> new String[integer];
        String[] apply = function.apply(3);
        System.out.println("Arrays.toString(apply) = " + Arrays.toString(apply));

        Function<Integer,String[]> function2= String[]::new;
        String[] apply1 = function2.apply(6);
        System.out.println("Arrays.toString(apply1) = " + Arrays.toString(apply1));

        ArrayList<Object> objects = new ArrayList<>();
        Stream<Object> objectStream = objects.parallelStream();

        Stream.iterate(0,t->t+2);

    }

}
