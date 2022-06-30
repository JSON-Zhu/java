package com.test.enums;

import java.util.concurrent.TimeUnit;

/**
 * TestEnums
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/19 22:35
 **/
public class TestEnums {

    enum  SEASON{
        SPRING("春天","风和日丽"),
        SUMMER("夏天","汗如雨下");

        private final String name;
        private final String nameDesc;

        private SEASON(String name,String nameDesc){
            this.name=name;
            this.nameDesc=nameDesc;
        }

        @Override
        public String toString() {
            return "SEASON{" +
                    "name='" + name + '\'' +
                    ", nameDesc='" + nameDesc + '\'' +
                    '}';
        }
    }
    enum TEST3 implements test{
        TEST{
            @Override
            public void test() {
                System.out.println("test1 override");
            }
        },
        TEST2{
            @Override
            public void test() {

                System.out.println("test2 override");
            }
        };

    }
    interface test{
        void test();
    }

    public static void main(String[] args) {
        System.out.println(SEASON.SPRING);
        System.out.println(TEST3.TEST2);
        System.out.println("============");


        TEST3[] values = TEST3.values();
        for (TEST3 value : values) {
            value.test();
        }
    }

}
