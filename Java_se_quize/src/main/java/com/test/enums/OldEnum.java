package com.test.enums;

import com.sun.istack.internal.NotNull;

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

/**
 * OldEnum
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/19 23:03
 **/
@MyAnnotation(value = "class",value2 = "class")
public class OldEnum<@MyAnnotation T>  {
    public static final OldEnum spring=new OldEnum("春天","风和日丽");

    public static final OldEnum summer=new OldEnum("夏天","汗如雨下");

    private final String name;
    private final String nameDesc;

    private OldEnum(String name,String nameDesc){
        this.name=name;
        this.nameDesc=nameDesc;
    }

    @Override
    public String toString() {
        return "OldEnum{" +
                "name='" + name + '\'' +
                ", nameDesc='" + nameDesc + '\'' +
                '}';
    }

    //jdk8.0之后的写法
    @MyAnnotation(value2 = "test2",value = "method")
    @MyAnnotation(value = "method",value2 = "test")
    @MyAnnotation(value2 = "test2",value = "method")
    @MyAnnotation(value = "method",value2 = "test")
    public int reflectAnnotation(@NotNull int b){
        int a=0;
        return 0;
    }

    @Deprecated
    public static void main(@MyAnnotation String[] args) throws NoSuchFieldException, NoSuchMethodException {
        Method[] methods = OldEnum.class.getMethods();
//        for (Method method : methods) {
//            if (method.getAnnotations()==null||method.getAnnotations().length==0) {
//                continue;
//            }
//            for (Annotation annotation : method.getAnnotations()) {
//                System.out.println(annotation.annotationType());
//                System.out.println(annotation);
//            }
//        }

        ArrayList<@MyAnnotation String> strings = new ArrayList<>();
        Annotation[] annotation = OldEnum.class.getMethod("reflectAnnotation",int.class).getAnnotations();
        for (Annotation annotation1 : annotation) {
            System.out.println(annotation1);
        }



        //System.out.println(OldEnum.class.isAnnotation());

    }
}
