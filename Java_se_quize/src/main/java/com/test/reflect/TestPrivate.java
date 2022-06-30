package com.test.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * TestPrivate
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/19 3:00
 **/
public class TestPrivate {
    public static void main(String[] args) throws Exception {
        Class<D3NewInstance> d3NewInstanceClass = D3NewInstance.class;

        Constructor<?>[] declaredConstructors = d3NewInstanceClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            declaredConstructor.setAccessible(true);
            Parameter[] parameters = declaredConstructor.getParameters();
            if (parameters != null && parameters.length != 0) {
                D3NewInstance d3NewInstance = (D3NewInstance) declaredConstructor.newInstance("x");
                System.out.println(d3NewInstance);
            }

            //D3NewInstance d3NewInstance = d3NewInstanceClass.newInstance();

        }
        //获取类的注解
        Annotation[] annotations = d3NewInstanceClass.getAnnotations();
        if (annotations != null && annotations.length != 0) {
            for (Annotation annotation : annotations) {
                System.out.println("annotation = " + annotation);
            }
        }

        //获取方法抛出的异常
        Method[] methods = d3NewInstanceClass.getMethods();
        for (Method method : methods) {
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            if (exceptionTypes != null && exceptionTypes.length != 0){
                System.out.println(method);
                int modifiers = method.getModifiers();
                System.out.println(modifiers);
                for (Class<?> exceptionType : exceptionTypes) {
                    System.out.println(exceptionType);
                }

            }
        }
        System.out.println("------------------------");
        Type genericSuperclass = d3NewInstanceClass.getGenericSuperclass();

        ParameterizedType genericSuperclass1 = (ParameterizedType) genericSuperclass;

        for (Type actualTypeArgument : genericSuperclass1.getActualTypeArguments()) {
            System.out.println(actualTypeArgument.getTypeName());
        }

        System.out.println(genericSuperclass);

        for (Type genericInterface : d3NewInstanceClass.getGenericInterfaces()) {
            System.out.println(genericInterface);
            System.out.println(genericInterface.getTypeName());
        }

        Class<?>[] interfaces = d3NewInstanceClass.getSuperclass().getInterfaces();


    }
}
