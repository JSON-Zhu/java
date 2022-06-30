package com.test.proxy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ProxyTest
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/19 8:12
 **/
public class ProxyTest {
    public static void main(String[] args) throws Exception{
//        Actor agent = new Agent(new Star());
//        agent.makeMoney();
//        agent.signContract();
        Class<Star> starClass = Star.class;
        Star star = starClass.newInstance();
        Method makeMoney = starClass.getMethod("makeMoney");

        makeMoney.invoke(star);

        Field moneyMade = starClass.getDeclaredField("moneyMade");

        FieldTest fieldTest = new FieldTest();


        Class<ProxyTest> proxyTestClass = ProxyTest.class;

        ClassLoader classLoader = ProxyTest.class.getClassLoader();
        Class<?> aClass = classLoader.loadClass("com.test.proxy.FieldTest");
        System.out.println(aClass.getName());



    }

    interface Actor {
        int makeMoney();

        void signContract();
    }

    static class Star implements Actor {
        private double moneyMade;
        @Override
        public int makeMoney() {
            System.out.println("明星挣钱");
            return 1000000;
        }

        @Override
        public void signContract() {

        }
    }

    static class Agent implements Actor {
        private Actor actor;

        public Agent(Actor actor) {
            this.actor = actor;
        }

        @Override
        public int makeMoney() {
            actor.makeMoney();
            return 100;
        }

        @Override
        public void signContract() {
            System.out.println("代理人签合同");
        }
    }
}
