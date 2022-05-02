package com.test.jvm;

/**
 * EnterClass
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/4/21 20:13
 **/
public class EnterClass {

    private String message;

    private char[] chars;

    public void showMessage( /*0xEEAA*/ String message) {
        message = new String("new value");
        System.out.println("message = " + this.message);
        System.out.println("message = " + message);
    }

    public void showArray(/*0xABCD*/ char[] charArray) {

        /*charArray = new char[]{'x', 'y', 'z'};*/

        charArray=new char[]{'g','f','k'};
        charArray[2]='W';
        System.out.println("charArray[2] = " + charArray[2]);
        System.out.println("chars[2] = " + chars[2]);
    }

    public static void main(String[] args) {

        EnterClass enterClass = new EnterClass();

        // 给对象的成员变量赋值
        enterClass.message = new String("hello");
        System.out.println(enterClass.message.intern());
        // 将对象的成员变量作为参数传入 showMessage() 方法
        enterClass.showMessage(enterClass.message);

        // 创建数组对象
        char[] charArray = new char[]{'a','b','c','d','e'};

        enterClass.chars=charArray;

        // 将数组作为参数传入 showArray() 方法
        enterClass.showArray(charArray);

    }

}
