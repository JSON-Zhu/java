package com.test.concurrent.threadcomm;

/**
 * Interrupted
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/1 19:07
 **/
public class Interrupted {

    public static void main(String[] args) {
        Thread thread= new X();

        thread.start();

//        Thread.currentThread().interrupt();
//        System.out.println("第一次"+Thread.interrupted());  //true
//        System.out.println("第二次"+Thread.interrupted());  //false


        Thread.currentThread().interrupt();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("我被打断了");
            e.printStackTrace();
        }

        System.out.println("第一次"+Thread.currentThread().isInterrupted());
        System.out.println("第二次"+Thread.currentThread().isInterrupted());

    }

}

class X extends Thread {
    @Override
    public void run() {

    }
}
