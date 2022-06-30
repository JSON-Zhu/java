package com.test.enums;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;

/**
 * StringTest
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/20 23:59
 **/
public class StringTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String x = "1aaa2b3c5d,,,";
        String s = x.replaceAll("[a-z]{1,2}.$", "");
        String s2 = x.replaceAll("(aa)+", "");
        System.out.println(s);
        System.out.println(s2);
        System.out.println(x);
        String phone = "089273808708080808";
        //System.out.println("符合状态:" + phone.matches("[1][0-9]{10}"));
        //System.out.println("符合状态:" + phone.matches("[1][0-9]{10}"));
        byte[] gbks = phone.getBytes("utf-8");
        //System.out.println(Arrays.toString(gbks));
        //System.out.println(new String(gbks));
        System.out.println(phone.replaceAll("^\\s*|\\s*$", ""));

        //1. 字符串按字符自然顺序排序
//        char[] chars = phone.toCharArray();
//        Arrays.sort(chars);
//        System.out.println(Arrays.toString(chars));
        //new StringTest().searchIndexOfSubstring("0", phone, 0);
        /**
         * 获取子串出现的次数
         */
        int i = 0;
        int index ;
        int startIndex = 0;
        for (; ; ) {
            index = phone.indexOf("08", startIndex);
            if (index == -1) {
                break;
            } else {
                System.out.println("第" + (++i) + "个" + ",位置:" + index);
                startIndex=index+1;
            }
        }

        int[] ints = {1, 2};
        int[] ints1 = Arrays.copyOf(ints, ints.length << 1);
        System.out.println(ints==ints1);
        for (int i1 = 0; i1 < ints.length; i1++) {
            System.out.println(ints[i1]);
            System.out.println(ints1.length+"::"+ ints1[i1]);
        }

        StringBuffer stringBuffer = new StringBuffer();
        System.out.println(stringBuffer
                .append("testtestteetteee")
                .replace(0, stringBuffer.length(), "tt"));
        final  Integer integer = new Integer(5);

    }

    int i = 0;

    //获取子串的次数
    public void searchIndexOfSubstring(String sString, String pString, int startSearchIndex) {
        int index = 0;

        index = pString.indexOf(sString, startSearchIndex);
        if (index == -1) {
            return;
        } else {
            i++;
            System.out.println("第" + i + "个" + ",位置:" + index);
            searchIndexOfSubstring(sString, pString, index + sString.length());
        }
    }
}

