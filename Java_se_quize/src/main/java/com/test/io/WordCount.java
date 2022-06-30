package com.test.io;

import java.io.*;
import java.util.*;

/**
 * WordCount
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/17 10:00
 **/
public class WordCount {

    public static void main(String[] args) throws IOException {
//        HashMap<Character, Integer> countMap = new HashMap<>();
//        FileReader fileReader = new FileReader(
//                new File("D:\\00\\Java\\Java_se_quize\\src\\main\\java\\com\\test\\io\\FileTest.txt"));
//
//        int c;
//        while ((c = fileReader.read()) != -1) {
//            char key = (char) c;
//            if (countMap.get(key) == null) {
//                countMap.put(key, 1);
//            } else {
//                countMap.put(key, countMap.get(key) + 1);
//            }
//        }
//        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
//            System.out.println(entry.getKey() + "::" + entry.getValue());
//        }
//
//        fileReader.close();
        WordCount.wordCount(new File("D:\\00\\Java\\Java_se_quize" +
                "\\src\\main\\java\\com\\test\\io\\FileTest.txt"));

    }

    //本方法.利用char数组.一个个读字符
    public static void wordCount(File file) throws IOException {
        HashMap<String, Integer> countMap = new HashMap<>();
        FileReader fileReader = new FileReader(file);

        int c;
        char[] chars = new char[10];
        ArrayList<Character> characters = new ArrayList<>();
        boolean wordStatus = true;
        int readCount = 0;

        while ((c = fileReader.read()) != -1) {
            char character = (char) c;
            if (character == ',')
                continue;
            if (character != ' ') {
                chars[readCount++] = character;
            } else {
                //读到空格,且字符数组非空时统计入map.
                if (chars[0] != '\u0000') {
                    String s = new String(chars,0,readCount);
                    if (!countMap.keySet().contains(s)) {
                        countMap.put(s, 1);
                    } else {
                        countMap.put(s, countMap.get(s) + 1);
                    }
//                    for (int i = 0; i < readCount; i++) {
//                        chars[i] = ' ';
//                    }
                    //chars;
                    readCount = 0;
                }
            }
        }
        //最后读完后,chars是否还有值
        if (chars[0] != '\u0000') {
            String s = new String(chars,0,readCount);
            if (!countMap.keySet().contains(s)) {
                countMap.put(s, 1);
            } else {
                countMap.put(s, countMap.get(s) + 1);
            }
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : countMap.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + "::" + stringIntegerEntry.getValue());
        }


    }

    //使用readLine
    public static void wordCount2(File file) throws IOException {
        HashMap<String, Integer> countMap = new HashMap<>();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String c;

        while ((c = bufferedReader.readLine()) != null) {
            String s = c.replace(',', ' ').replace('.', ' ');
            String[] s1 = s.trim().split(" ");
 
            for (String s2 : s1) {
                if(s2.equals(""))
                    continue;
                if (countMap.get(s2) == null) {
                    countMap.put(s2, 1);
                } else {
                    countMap.put(s2, countMap.get(s2) + 1);
                }
            }
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : countMap.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + "::" + stringIntegerEntry.getValue());
        }


    }
}
