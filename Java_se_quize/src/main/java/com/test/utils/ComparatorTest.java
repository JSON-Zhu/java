package com.test.utils;

import java.util.Comparator;

/**
 * ComparatorTest
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/20 18:06
 **/
public class ComparatorTest {


    public static void main(String[] args) {
        String a ="test";
        String b = "Zack";
        System.out.println(a.compareToIgnoreCase(b));

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareToIgnoreCase(o1);
            }
        };

        System.out.println(comparator.compare(a, b));

        String x=new String("test");
        String x1=new String("test1");
        System.out.println(x == x1);
        x=",,,,hell333o32xte33ll,,";
        x1="hello";
        System.out.println(x==x1);
        System.out.println("x.charAt(3) = " + x.charAt(3));
        System.out.println(x);
        System.out.println(x.replace("h", "x"));
        System.out.println(x);
        System.out.println(x.replaceAll("\\d{2,3}", ""));
        System.out.println("x.replaceAll(\"^,\",\"\") = " + x.replaceAll("^,{1,4}|,{1,4}$", ""));


    }

}
