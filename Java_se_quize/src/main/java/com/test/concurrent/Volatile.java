package com.test.concurrent;

/**
 * Volatile
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/4/14 22:19
 **/
public class Volatile implements Runnable {

    private volatile static int a=0;

    public static void main(String[] args) {
        Volatile aVolatile = new Volatile();
        Volatile bVolatile = new Volatile();
        Thread thread = new Thread(aVolatile);
        Thread thread1 = new Thread(bVolatile);
        thread.start();
        thread1.start();
        thread.run();
        thread1.run();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            // 数字大一些，不然看不到效果
            // 这里在a++前后打印变量值
            System.out.println(Thread.currentThread().getId()+" before a = " + a);
            a++;
            System.out.println(Thread.currentThread().getId()+" after a = " + a);
        }
    }
}
