package com.test.utils;

import org.junit.Test;

import java.util.Date;
import java.util.Objects;

/**
 * Person
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/23 11:33
 **/
public class Person implements Comparable ,Cloneable{

    @Test
    public void test3(){
        Person person = new Person();

    }

    private static String string=test();

    @Override
    public Person clone() throws CloneNotSupportedException {
        Person clone = (Person) super.clone();
        //clone.birthday=(Date) birthday.clone();

        return clone;
    }

    static {
        System.out.println("静态代码块");
    }

    private String name;
    private Integer age;
    private Date birthday;

    public Person() {
        System.out.println("空参构造器");
    }

//    public Person(String name, Integer age,Date birthday) {
//        this.name = name;
//        this.age = age;
//        this.birthday=birthday;
//    }

    public static String test(){
        return "静态变量";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        try {
            Person clone = person.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (!Objects.equals(name, person.name)) return false;
        return Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Person))
            throw new RuntimeException("输入对象类型异常");
        Person person = (Person) o;
        if (name.equals(person.name)) {
            return age.compareTo(person.age);
        }
        return name.compareToIgnoreCase(person.name);
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
