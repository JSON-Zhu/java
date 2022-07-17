package com.test.concurrent.threadcomm;


/**
 * ThreadJoinTest
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/7/13 15:59
 **/
class JoinRelease {

    static Object object = new Object();

    public static void main2(String[] args) throws InterruptedException {

        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(new SubThread());
            thread.setName("thread-" + i);
            thread.start();
            thread.join();
            Thread.sleep(1000);
        }
        System.out.println("主线程结束");
    }

    static class SubThread implements Runnable {
        @Override
        public void run() {
            synchronized (Thread.currentThread()) {
                System.out.println("获取到锁！！！ThreadName: " + Thread.currentThread().getName());

            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("执行" + Thread.currentThread().getName() + i);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程" + Thread.currentThread() + "执行结束");

    }

}

class JoinTest {

    Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        JoinTest joinTest = new JoinTest();
        joinTest.main();
    }

    public void main() throws InterruptedException {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2(thread1);

        thread1.start();
        thread2.start();
        //thread1.interrupt();
        Thread.sleep(3000L);
        synchronized (thread1) {
//            int i = 0;
//            while (i < 10) {
            for (; ; ) {
                Thread.sleep(1500);
                int i = 0;
                System.out.println("执行" + Thread.currentThread().getName() + "中的同步代码块" + ":::" + (i++));
                //  }
                //i++;
            }
        }
    }

    class Thread1 extends Thread {
        @Override
        public void run() {
            System.out.println("开始执行" + Thread.currentThread().getName() + "...");
            try {
                int i = 0;
                while (i < 10) {
                    System.out.println("执行" + Thread.currentThread().getName() + "中的同步代码块");
                    Thread.sleep(1000L);
                    i++;
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被interrupt,此时该线程的interpret标记位为：" + Thread.interrupted());
            }
            System.out.println("结束执行" + Thread.currentThread().getName() + "！！！");
        }
    }

    class Thread2 extends Thread {
        private final Thread1 thread1;

        private java.lang.Object lock = new java.lang.Object();

        public Thread2(Thread1 thread1) {
            this.thread1 = thread1;
        }

        @Override
        public void run() {
            System.out.println("开始执行" + Thread.currentThread().getName() + "...");
            try {
                synchronized (lock) {
                    System.out.println("进入同步代码块");
                    thread1.join();
                    System.out.println("同步代码块执行结束");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结束执行" + Thread.currentThread().getName() + "！！！");
        }
    }
}





