//package com.test.utils;
//
//import com.test.javaee.StringTest;
//import org.junit.Test;
//
//import java.util.*;
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.locks.Lock;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
///**
// * StreamTest
// *
// * @author XQ.Zhu
// * @version 1.0
// * 2022/5/24 22:31
// **/
//public class StreamTest {
//
////    @Test
////    public void test02() {
////        List<Person> people = new ArrayList<>();
////        Person p1 = new Person("张三", 18,new Date());
////        Person p2 = new Person("李四", 19,new Date());
////        Person p3 = new Person("王二狗", 2,new Date());
////        Person p4 = new Person("李三丰", 22,new Date());
////
////        people.add(p1);
////        people.add(p2);
////        people.add(p3);
////        people.add(p4);
////
////        people.stream()
////                .filter(person -> person.getAge() > 19)
////                .forEach(System.out::println);
////        System.out.println("========");
////        for (Person person : people) {
////            if (person.getAge()>19) {
////                System.out.println(person);
////            }
////        }
//
////        people.stream().map(Person::getName).filter(name -> name.length() > 2).forEach(System.out::println);
////
////        System.out.println();
////
////        people.stream().map(Person::getName).map(StreamTest::stringToCharArr).forEach(
////                s -> s.forEach(System.out::println)
////        );
////        System.out.println();
////        people.stream().map(Person::getName).flatMap(StreamTest::stringToCharArr).forEach(System.out::println);
//
////        System.out.println();
////
////        people.stream().map(person -> person.getAge()+1).forEach(System.out::println);
////
////        System.out.println();
////
////        people.stream().mapToInt(person->person.getAge()+1).forEach(System.out::println);
//
//        boolean b = people.stream().anyMatch(person -> person.getAge() > 18);
//        System.out.println(b);
//
//        System.out.println(people.parallelStream().count());
//
//        System.out.println(people.parallelStream().max(Comparator.comparingInt(Person::getAge)));
//
//        people.forEach(System.out::println);
//
//        for (Person person : people) {
//            System.out.println(person);
//        }
//    }
//
//    public static Stream<Character> stringToCharArr(String string) {
//        List<Character> characters = new ArrayList<>();
//        char[] chars = string.toCharArray();
//        for (char aChar : chars) {
//            characters.add(aChar);
//        }
//        return characters.stream();
//
//    }
//
//    @Test
//    public void test3() {
//        List<Person> people = new ArrayList<>();
//
//        Person p1 = new Person("张三", 18,new Date());
//        Person p2 = new Person("李四", 19,new Date());
//        Person p3 = new Person("王二狗", 2,new Date());
//        Person p4 = new Person("李三丰", 22,new Date());
//        people.add(p1);
//        people.add(p2);
//        people.add(p3);
//        people.add(p4);
//
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        System.out.println(list.stream().reduce(5, Integer::sum));
//
//        Optional<Integer> reduce = people.stream().map(Person::getAge).reduce(Integer::sum);
//        System.out.println(reduce.get());
//        ThreadPoolExecutor threadPoolExecutor =
//                new ThreadPoolExecutor(3,
//                        10,
//                        10,
//                        TimeUnit.SECONDS,
//                        new ArrayBlockingQueue<>(3),
//                        Executors.defaultThreadFactory(),
//                        new ThreadPoolExecutor.CallerRunsPolicy());
//        threadPoolExecutor.execute(()->{
//
//        });
//
//
////        System.out.println();
////
////        //获得名字超过2个长度的,第三个字符的值
////        people.stream().filter(e-> e.getName().length()>2).map(Person::getName)
////                .map(e-> e.charAt(2)).map(String::valueOf).forEach(System.out::println);
////        System.out.println();
////        List<String> collect = people.stream().filter(e -> e.getName().length() > 2).map(Person::getName)
////                .map(e -> e.charAt(2)).map(String::valueOf).collect(Collectors.toList());
////
////        collect.forEach(System.out::println);
////
////        System.out.println((char[]) null);
//
//    }
//
//}
