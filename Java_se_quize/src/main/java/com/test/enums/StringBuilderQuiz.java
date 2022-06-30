package com.test.enums;

import java.util.concurrent.TimeUnit;

/**
 * StringBuilderQuize
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/21 3:21
 **/
public class StringBuilderQuiz {
    public static void main(String[] args) {
        long startTime=0;
        long endTime=0;
        String text="";
        StringBuilder stringBuilder = new StringBuilder("");
        StringBuffer stringBuffer = new StringBuffer("");

         startTime= System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            text+=i;
        }
        endTime=System.currentTimeMillis();
        System.out.println("耗时:" + ((endTime - startTime)) + "s");

        startTime= System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            stringBuffer.append(i);
        }
        endTime=System.currentTimeMillis();
        System.out.println("stringBuffer耗时:" + ((endTime - startTime)) + "s");

        startTime= System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            stringBuilder.append(i);
        }
        endTime=System.currentTimeMillis();
        System.out.println("stringBuilder耗时:" +((endTime - startTime)) + "s");

    }
}
