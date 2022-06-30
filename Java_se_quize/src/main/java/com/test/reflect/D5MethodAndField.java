package com.test.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * D5MethodAndField
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/19 2:18
 **/
public class D5MethodAndField extends Father implements MyInterface, Comparable<String> {

    String name;

    public D5MethodAndField(String name) {
        this.name = name;
    }

    public D5MethodAndField() {
    }

    @MyAnnotation("testJava")
    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Class<D5MethodAndField> d5MethodAndFieldClass = D5MethodAndField.class;

        for (Method declaredMethod : d5MethodAndFieldClass.getDeclaredMethods()) {
            Annotation[] annotations = declaredMethod.getAnnotations();
            if (annotations.length !=0) {

                System.out.println(declaredMethod);
                for (Annotation annotation : annotations) {
                    System.out.println(annotation);
                }

            }
        }

    }

    @Override
    public void testClass() {
        System.out.println("我是测试Class");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}

class Father {
    String age;

    public Father() {
    }

    public Father(String age) {
        this.age = age;
    }
}
