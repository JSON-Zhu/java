package com.test.javaee;

/**
 * Polymorphism
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/4/26 18:44
 **/
public class Polymorphism extends Father{

    public int fatherInt = 80;

    public static void main(String[] args) {
        Father father = new Polymorphism();
        System.out.println(father.fatherInt);
    }

}

class Father extends GrandFather{
    public int fatherInt2 = 8;
    Father() {
        super();
    }
}
class GrandFather{
    public int fatherInt = 9;
}
