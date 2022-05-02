package com.test.concurrent.threadcomm;

import java.util.concurrent.TimeUnit;

/**
 * Notify
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/4/30 0:01
 **/
public class Notify {

    private Integer num = 0;

    public void add() {
        try {
            synchronized (this) {
                while (num > 0) {
                    this.wait();
                }
                System.out.println(Thread.currentThread().getName() + ":" + (++num));
                this.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sub() {
        try {
            synchronized (this) {
                while (num == 0) {
                    this.wait();
            }
                System.out.println(Thread.currentThread().getName() + ":" + (--num));
                this.notifyAll();
                }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Notify notify = new Notify();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                notify.add();
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread-add").start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                notify.sub();
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread-sub").start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                notify.add();
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread-add2").start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                notify.sub();
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread-sub2").start();

    }

}
