package com.test.jvm;

/**
 * StackOverFlow
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/4/24 22:14
 **/
import java.util.concurrent.TimeUnit;

/**
 * 栈空间线程私有性验证。验证方式：
 *      创建 A、B、C 三个线程，其中 B 线程抛出栈溢出异常。看看其它两个线程是否还能继续正常工作。
 * Lambda 表达式口诀：
 *      复制小括号
 *      写死右箭头
 *      落地大括号
 */
public class StackThreadPrivateTest {

    public static void main(String[] args) {
//        new Thread(()->{
//            while (true) {
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                    System.out.println(Thread.currentThread().getName() + " is working");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, "thread-a").start();
//
//        StackThreadPrivateTest testObj = new StackThreadPrivateTest();
//
//        new Thread(()->{
//
//            // 调用无限递归方法，把当前线程搞崩溃
//            testObj.methodRecursive();
//
//        }, "thread-b").start();
//
//        new Thread(()->{
//            while (true) {
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                    System.out.println(Thread.currentThread().getName() + " is working");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, "thread-c").start();

        System.out.println("Runtime.getRuntime().maxMemory() = " + Runtime.getRuntime().maxMemory()/1000000);
        System.out.println("Runtime.getRuntime().totalMemory() = " + Runtime.getRuntime().totalMemory()/1000000);
        System.out.println("Runtime.getRuntime().freeMemory() = " + Runtime.getRuntime().freeMemory()/1000000);

        System.gc();



    }

    public void methodRecursive() {
        methodRecursive();
    }
}
