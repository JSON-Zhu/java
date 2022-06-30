package com.test.enums;

import java.lang.annotation.*;

/**
 * MyAnno
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/20 0:02
 **/
@Target({ElementType.TYPE_USE,ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyAnnotations.class)
public @interface MyAnnotation {
    String value() default "myAnnotation";
    String value2() default "test";

}
