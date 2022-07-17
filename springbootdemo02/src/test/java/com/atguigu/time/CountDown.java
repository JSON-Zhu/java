package com.atguigu.time;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * CountDown
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/7/16 17:38
 **/
public class CountDown {
    private int limitSec;
    private int curSec;
    private int timeElapsed;

    public CountDown() {

    }

//    public CountDown(int limitSec) throws InterruptedException {
//        this.limitSec = limitSec;
//        this.curSec = limitSec;
//        System.out.println("count down from " + limitSec + " s ");
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            public void run() {
//                System.out.println(Thread.currentThread().getName() + ":::" + "Time remains " + --curSec + " s" + "time elapsed::" + (++timeElapsed));
//            }
//        }, 0, 1000);
//        TimeUnit.SECONDS.sleep(limitSec);
//        timer.cancel();
//        System.out.println(Thread.currentThread().getName() + "Time is out!");
//    }

    public static void main(String[] args) throws InterruptedException, IOException {

        //CountDown countDown = new CountDown(10);

//        String test = "🍷hello";
//        System.out.println(test.length());//得到的是代码单元的数量 8 🍷占两个代码单元
//        System.out.println(test.codePointCount(0, test.length()));//得到的是码点的数量7
////        System.out.println("test.charAt(1) = " + test.charAt(1));
////        System.out.println("test.charAt(1) = " + test.charAt(0));
////        System.out.println("test.charAt(1) = " + test.charAt(2));
////
////        int i = test.offsetByCodePoints(0, 1);
////        System.out.println("test.codePointAt(1) = " + test.codePointAt(0));
//
//        int[] ints = test.codePoints().toArray();
//        for (int anInt : ints) {
//            System.out.println("(char)anInt = " + (char) anInt);
//        }
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder stringBuilder = new StringBuilder();
//        //将码点数组转换成字符串
//        String str = new String(ints, 0, ints.length);
//        System.out.println(str);

        //test2();
        String x="1024";
        System.out.println("x.getBytes() = " + Arrays.toString(x.getBytes()));

    }

    //@Test
    public static void test2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String[] strs = new String[count];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = br.readLine().toLowerCase();
        }
        Integer integer = new Integer("777786788");
        System.out.println(integer.byteValue());

        Arrays.sort(strs, (s1,s2)-> -s1.compareToIgnoreCase(s2));
        for (String str : strs) {
            System.out.println(str);
        }
    }
}
