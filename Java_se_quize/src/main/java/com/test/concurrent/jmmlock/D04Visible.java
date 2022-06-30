package com.test.concurrent.jmmlock;

import java.util.concurrent.TimeUnit;

/**
 * D01AtomicInt
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/6 8:07
 **/
public class D04Visible {

    private volatile int data = 100;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public static void main(String[] args) {

        D04Visible demo = new D04Visible();

        new Thread(()->{

            while (demo.getData() == 100) {}

            System.out.println("AAA 线程发现 data 新值：" + demo.getData());

        }, "AAA").start();

        new Thread(()->{

            try {
                TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {}

            demo.setData(200);

            System.out.println("BBB 线程修改 data，新值是：" + demo.getData());

        }, "BBB").start();

    }

}
