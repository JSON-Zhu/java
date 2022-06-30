package com.test.concurrent.threadpool;

import java.util.UUID;
import java.util.concurrent.*;

/**
 * Thread
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/7 23:38
 **/
public class D01ThreadTest {

    public static void main(String[] args) {
// 创建一个BlockingQueue对象
        BlockingQueue<String> breadShop = new ArrayBlockingQueue<>(3);

// 创建一个线程用于存放出炉的面包
        new Thread(()->{
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    String bread = UUID.randomUUID().toString().replace("-", "").substring(0, 5);
                    System.out.println("面包出炉：" + bread + " 货架情况：" + breadShop);
                    breadShop.put(bread);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"1").start();

// 创建一个线程用于卖面包
        new Thread(()->{
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep((int)(Math.random()*10));
                    String bread = breadShop.take();
                    System.err.println("面包卖出：" + bread + " 货架情况：" + breadShop);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"2").start();

    }

}
