package com.atguigu;

/**
 * com.atguigu.NativeMethod
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/6/21 18:25
 **/
public class NativeMethod {
    public native void greeting();
    static {
        System.loadLibrary("NativeMethod2");
    }

    public static void main(String[] args) {
        new NativeMethod().greeting();
    }
}
