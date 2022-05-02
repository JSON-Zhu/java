package com.test.concurrent.juc;

/**
 * SellTickets
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/4/27 20:53
 **/
public class SellTickets implements Runnable {
    private static Integer ticketsLeft = 100;
    
    public synchronized static void sellTicket() {
        Object o = new Object();
        try {
            //o.wait(1000);
            SellTickets.class.wait(1000);
            if (ticketsLeft > 0) {
                System.out.println(
                        Thread.currentThread().getName() + "窗口还剩:" + --ticketsLeft + "张票."
                );
            } else {
                System.out.println("票卖完了");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Object o = new Object();
        //创建三个线程
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                SellTickets.sellTicket();
            }
        }, "thread-a").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                SellTickets.sellTicket();
            }
        }, "thread-b").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                SellTickets.sellTicket();
            }
        }, "thread-c").start();

        new Thread(()->{
            System.out.println("x");
        },"thread-lambda");

    }

    @Override
    public void run() {

    }
}

class MyThread extends Thread {

    @Override
    public void run() {

    }
}
