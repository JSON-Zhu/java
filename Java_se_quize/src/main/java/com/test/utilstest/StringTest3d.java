package com.test.utilstest;

import java.util.ArrayList;

/**
 * StringTest3d
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/21 14:04
 **/
public class StringTest3d {
    public static void main(String[] args) {
        String x="abccdefghelloxyzz";
        String y="dabddcchellxyzz";
        stringCompare(y,x);
    }
    //查找最大字符子串

    /**
     * 左右分别移动i位,固定左边,外层控制右边,
     * @param s1
     * @param s2
     */
    public static void stringCompare(String s1, String s2){
        String minStr= s1.length()>=s2.length()?s2:s1;
        String maxStr= s1.length()< s2.length()?s2:s1;
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < minStr.length(); i++) {
            for (int x = 0,y=minStr.length()-i; y <=minStr.length() ; x++,y++) {
                String substring = minStr.substring(x, y);
                if(maxStr.contains(substring)){
                    strings.add(substring);
                }
            }
            //找到立即跳出
            if (!strings.isEmpty()) {
                break;
            }
        }
        System.out.println(strings.toString());

    }

}
