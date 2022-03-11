package com.part3;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflexUtils {
    public static void reflex(Object o) {
        Class<?> objClazz = o.getClass();
        //反射方法
        //1、获取该类中的所有方法
        Method[] declaredMethods = objClazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            method.setAccessible(true);
            //2、获取该方法上的注解
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                //3、判断该注解的类型
                if (annotation instanceof MethodInject) {
                    try {
                        //4、获取注解的属性值
                        int id = ((MethodInject) annotation).id();
                        String print = ((MethodInject) annotation).print();
                        //5、将注解上的值赋值给该方法
                        method.invoke(o, print + id);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        //反射变量
        //1、获取该类中的所有成员变量
        Field[] declaredFields = objClazz.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            //2、获取该成员变量上的注解
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                //3、判断注解的类型
                if (annotation instanceof FieldInject) {
                    try {
                        //4、获取注解的属性值
                        String name = ((FieldInject) annotation).name();
                        //5、将注解上的值赋值给该变量
                        field.set(o, name);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }
}
