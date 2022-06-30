package com.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Calendar;
import java.util.Comparator;

/**
 * DynamicProxy
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/19 21:17
 **/
public class DynamicProxy {

    interface add {
        int add(int i,int j);
    }

    static class Calculator implements add{
        public int add(int i, int j){
            System.out.println("计算期执行加法运算:"+i+"+"+j+"="+(i+j));
            return i+j;
        }
    }

    static class ProxyObj {

        public Object getProxyObj(Object object){
            Object newProxyInstance = Proxy.newProxyInstance(object.getClass().getClassLoader(),
                    object.getClass().getInterfaces(), new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                            System.out.println("被代理方法即将执行"+"参数:"+args[0]+","+args[1]);
                            Object invoke = method.invoke(object, args);
                            System.out.println("被代理方法结束执行"+"结果:"+invoke.toString());

                            return invoke;
                        }
                    });
            return newProxyInstance;
        }
    }

    public static void main(String[] args) {
        ProxyObj proxyObj = new ProxyObj();
        add proxyObj1 = (add) proxyObj.getProxyObj(new Calculator());
        proxyObj1.add(1,2);

    }



}
