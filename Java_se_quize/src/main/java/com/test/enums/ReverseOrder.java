package com.test.enums;

/**
 * ReverseOrder
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/20 22:24
 **/
public class ReverseOrder {
    public static void main(String[] args) {
        String test="helloworld1234567";
        char[] chars = test.toCharArray();

        int beginIndex=0,endIndex=0;
        //reverseArray(1,4,chars);
        //System.out.println(new String(chars));

        //从char[]反向取出
        StringBuilder stringBuilder2 = new StringBuilder("");
        for (int i = 4; i >=1 ; i--) {
            stringBuilder2.append(chars[i]);
        }
        System.out.println(new StringBuilder(test)
                .replace(1, 5, new String(stringBuilder2)).toString());

    }

    private static void reverseArray(int beginIndex, int endIndex, char[] chars) {

        char[] charsCopy = new char[chars.length];
        for (int i = 0; i < charsCopy.length; i++) {
            charsCopy[i]=chars[i];
        }
        int copyIndex=endIndex;
        for (int i = beginIndex; i < endIndex+1; i++) {

            chars[i]=charsCopy[copyIndex--];

        }
    }
}
