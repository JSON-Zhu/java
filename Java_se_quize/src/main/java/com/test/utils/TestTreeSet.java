//package com.test.utils;
//
//import org.junit.Test;
//
//import java.io.*;
//import java.time.Period;
//import java.util.*;
//import java.util.concurrent.CopyOnWriteArrayList;
//import java.util.regex.Pattern;
//
///**
// * AbstractTest
// *
// * @author XQ.Zhu
// * @version 1.0
// * 2022/5/23 8:51
// **/
//public class TestTreeSet {
//
//    @Test
//    public void test01() {
//
//        //自定义comparator实现定制排序.
////        TreeSet<Person> people = new TreeSet<>((o1, o2) -> {
////            System.out.println("调用定制排序");
////            if (!(o1 != null && o2 != null))
////                throw new RuntimeException("输入对象类型异常");
////
////            if (o1.getName().equals(o2.getName())) {
////                return -o1.getAge().compareTo(o2.getAge());
////            }
////            return -o1.getName().compareToIgnoreCase(o2.getName());
////        });
//
//        HashSet<Person> people = new HashSet<>();
//        Date date = new Date();
//        Person person = new Person("zhangsan", 19,date);
//        Person person1 = new Person("zhangsan", 19,date);
//        people.add(person);
//        people.add(person1);
//
//        Iterator<Person> iterator = people.iterator();
//        while (iterator.hasNext()) {
//            System.out.println("iterator.next() = " + iterator.next());
//        }
//
//        person.setName("lisi");
//
//
//        boolean remove = people.remove(person);
//        System.out.println("remove = " + remove);
//        System.out.println("删除后");
//        Iterator<Person> iterator2 = people.iterator();
//        while (iterator2.hasNext()) {
//            System.out.println("iterator.next() = " + iterator2.next());
//        }
//
//    }
//
//    @Test
//    public void test02() {
//
//        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
//        stringObjectHashMap.put("2", "x");
//        stringObjectHashMap.put("3", "y");
//        stringObjectHashMap.put("4", "z");
//
//        Collection<Object> values = stringObjectHashMap.values();
//        Iterator<Object> iterator = values.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//
//        Set<Map.Entry<String, Object>> entries = stringObjectHashMap.entrySet();
//        Iterator<Map.Entry<String, Object>> iterator1 = entries.iterator();
//        while (iterator1.hasNext()) {
//
//        }
//
//
//    }
//
//    class A {
//        private String name;
//        private Integer age;
//
//        public A(String name, Integer age) {
//            this.name = name;
//            this.age = age;
//        }
//
//        public void testA() {
//            System.out.println("A类");
//        }
//
//    }
//
//    class B extends A {
//        private B after;
//        private B before;
//
//        public B(String name, Integer age) {
//            super(name, age);
//        }
//
//        public void testA() {
//            System.out.println("B类");
//        }
//    }
//
//    @Test
//    public void test3() throws IOException {
//        A zhangsan = new B("zhangsan", 18);
//        A lisi = new B("李四", 18);
//        //zhangsan.testA();
//        Properties properties = new Properties();
//        properties.load(new FileInputStream("jdbc.properties"));
//        System.out.println(properties.get("result"));
//        System.out.println(properties.get("time"));
//
//    }
//
//    //统计java源程序中出现的关键字字数
//    @Test
//    public void test4() throws Exception {
//        File source = new File(
//                "D:\\00\\Java\\Java_se_quize" +
//                        "\\src\\main\\java\\com\\test\\utils\\Person.java");
//        Scanner scanner = new Scanner(
//                source);
//
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(source));
//        List<String> stringArrayList = new ArrayList<>();
//        String data;
//        while ((data = bufferedReader.readLine()) != null) {
//            String[] s = data.split(" ");
//            data.trim();
//            stringArrayList.addAll(Arrays.asList(s));
//        }
//
//        HashSet<String> strings = new HashSet<>();
//        strings.add("int");
//        strings.add("return");
//        strings.add("public");
//        strings.add("private");
//
//        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
//
//        for (String s : stringArrayList) {
//            if (strings.contains(s)) {
//                if (!stringIntegerHashMap.containsKey(s)) {
//                    stringIntegerHashMap.put(s, 1);
//                } else {
//                    Integer count = stringIntegerHashMap.get(s);
//                    stringIntegerHashMap.put(s, count + 1);
//                }
//            }
//        }
//
//        for (Map.Entry<String, Integer> stringIntegerEntry : stringIntegerHashMap.entrySet()) {
//            System.out.println(stringIntegerEntry.getKey() + "::" + stringIntegerEntry.getValue());
//        }
//
//    }
//
//}
