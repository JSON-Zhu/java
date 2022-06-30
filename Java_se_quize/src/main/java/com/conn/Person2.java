package com.conn;

import com.test.utils.Person;
import org.junit.*;

import java.util.Date;
import java.util.Objects;

/**
 * Person2
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/23 11:33
 **/
public class Person2 implements Comparable ,Cloneable{

    @Test
    public void test3(){
        Person2 person2 = new Person2();
    }

    public static void main(String[] args) {
        Person2 person2 = new Person2();
        //System.out.println(Person2.string);
    }

    private static String string=test();
    static {
        System.out.println("静态代码块");
    }

    @Override
    public Person2 clone() throws CloneNotSupportedException {
        Person2 clone = (Person2) super.clone();
        //clone.birthday=(Date) birthday.clone();

        return clone;
    }


    private String name;
    private Integer age;
    private Date birthday;

    public Person2() {
        System.out.println("空参构造器");
    }

//    public Person2(String name, Integer age,Date birthday) {
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

        Person2 person = (Person2) o;

        try {
            Person2 clone = person.clone();
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
        if (!(o instanceof Person2))
            throw new RuntimeException("输入对象类型异常");
        Person2 person = (Person2) o;
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
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
