package com.test.designmode;

import java.util.concurrent.TimeUnit;

/**
 * Singleton
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/21 6:09
 **/
public class SingletonLazy {

    //懒汉式

    private SingletonLazy() {
        try {
            TimeUnit.SECONDS.sleep(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static SingletonLazy singleton = null;

    public static SingletonLazy getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {

                    singleton = new SingletonLazy();
                }
            }
            //singleton=new SingletonLazy();
        }
        return singleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ":" + SingletonLazy.getSingleton());
            }).start();
        }
    }

}
