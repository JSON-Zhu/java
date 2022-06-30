package com.test.designmode;

/**
 * Singleton
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/21 6:09
 **/
public class Singleton {

    //饿汉式

    private Singleton() {
    }

    private static final Singleton singleton = new Singleton();

    public static Singleton getSingleton() {
        return singleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+Singleton.getSingleton());
            }).start();
        }
    }

}
