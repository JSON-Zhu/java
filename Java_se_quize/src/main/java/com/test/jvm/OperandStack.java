package com.test.jvm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * OperandStack
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/4/24 1:41
 **/
public class OperandStack {
    public static void main(String[] args) throws NoSuchMethodException,
            IllegalAccessException, InstantiationException, InvocationTargetException {
//        int n = 10;
//        n += (n+2) + (++n);
//        System.out.println(n);
//        add2(2,3);

        Class<OperandStack> operandStackClass = OperandStack.class;
        Method add2 = operandStackClass.getMethod("add2");
        System.out.println(operandStackClass.getName());
        System.out.println("Runtime.getRuntime().totalMemory() = " + Runtime.getRuntime().totalMemory()/1024/1024);
        ArrayList<Object> objects = new ArrayList<>();
        while (true){
            objects.add(objects);
        }

    }

    public void add2() {
        int i2=10/0;

    }
}
