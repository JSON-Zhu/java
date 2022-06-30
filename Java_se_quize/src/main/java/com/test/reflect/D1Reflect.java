package com.test.reflect;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * D1Reflect
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/18 20:55
 **/
public class D1Reflect {

    public static void main(String[] args) throws Exception {
        Class d1ReflectClass = D1Reflect.class;
        Constructor<D1Reflect> declaredConstructor = d1ReflectClass.getDeclaredConstructor(String.class);

        //declaredConstructor.setAccessible(true);

        D1Reflect newInstance = declaredConstructor.newInstance("张三");

        System.out.println(newInstance.toString());

        Method show = d1ReflectClass.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        Object invoke = show.invoke(newInstance, "::张三");
        System.out.println("invoke = " + invoke);
        Class<Class> classClass = Class.class;
        System.out.println(classClass.getName());

        D1Reflect x = new D1Reflect("x");
        Class<? extends D1Reflect> aClass = x.getClass();


        Class<ElementType> elementTypeClass = ElementType.class;
        System.out.println("elementTypeClass.getName() = " + elementTypeClass.getName());

        Class<Integer> integerClass = int.class;
        System.out.println("integerClass.getName() = " + integerClass.getName());

        Class<? extends int[]> aClass2 = new int[1].getClass();
        System.out.println("aClass2.getName() = " + aClass2.getName());

        ClassLoader classLoader = D1Reflect.class.getClassLoader();
        Class aClass1 = classLoader.loadClass("com.test.reflect.D1Reflect");
        System.out.println(aClass1.getName());
        System.out.println(d1ReflectClass==aClass1);

    }

    private String name;

    private D1Reflect(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void show(String name){
        System.out.println("我没有工作"+name);
    }

    @Override
    public String toString() {
        return "D1Reflect{" +
                "name='" + name + '\'' +
                '}';
    }
}
