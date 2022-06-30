package com.test.concurrent.threadcomm;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

/**
 * FinalizeTest
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/25 23:13
 **/
public class FinalizeTest {

    private static FinalizeTest testObj;

    @Override
    protected void finalize() throws Throwable {
        System.out.println(Thread.currentThread().getName() + "::" + "is working");
        testObj=this;
        int x=1/0;
    }

    public static void main(String[] args) {
        FinalizeTest testObj = new FinalizeTest();
        testObj=null;

        System.gc();

//        Runtime runtime = Runtime.getRuntime();
//        runtime.gc();


        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (FinalizeTest.testObj!=null) {
            System.out.println("拯救成功");
        }else {
            System.out.println("拯救失败");
        }

    }
    
    @Test
    public void test3(){
        Integer x = null;
        //int i = x.intValue();
        PrintStream printStream = new PrintStream(System.out) {
            @Override
            public void println(String x) {
                super.println("你好,这是重写的println");
            }
        };
        System.setOut(printStream);
        System.out.println("测试");
    }
}
