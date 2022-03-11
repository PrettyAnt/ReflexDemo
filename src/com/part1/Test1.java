package com.part1;

import com.part1.anno.MyAnnotation;
import com.part1.bean.People;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test1 {
    public static void main(String[] args) {
//        fansheTest();
        AnnFanSheTest();


    }

    /**
     * 泛型类的反射
     */
    private static void AnnFanSheTest() {
        try {
            Class<?> myAnnCls = Class.forName("com.part1.anno.MyAnnotationTest");
            System.out.println("---遍历---");
            Annotation[] annotations = myAnnCls.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
                if (annotation instanceof MyAnnotation) {
                    String name = ((MyAnnotation) annotation).name();
                    System.out.println(name);

                }
            }
            System.out.println("---单个---");
            MyAnnotation annotation = myAnnCls.getAnnotation(MyAnnotation.class);
            System.out.println(annotation.id());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 基本类的反射
     */
    private static void fansheTest() {
        try {
            Class<?> peopleClass = Class.forName("com.part1.bean.People");
            Constructor<?> declaredConstructor = peopleClass.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            Object instance = declaredConstructor.newInstance();
            System.out.println("---设置前---");
            System.out.println(instance);
            if (instance instanceof People) {
                System.out.println("---设置后---");
                //方式1：get/set方法
                ((People) instance).setName("wb");
                ((People) instance).setAge(16);
                System.out.println("方式1 get/set反射-->>" + instance);
                //方式2：反射变量
                Field declaredName = peopleClass.getDeclaredField("name");
                Field declareAge = peopleClass.getDeclaredField("age");
                declaredName.setAccessible(true);
                declareAge.setAccessible(true);
                declaredName.set(instance, "bft");
                declareAge.set(instance, 888);
                System.out.println("方式2 变量反射--->>" + instance);
            }
            Method getName = peopleClass.getDeclaredMethod("setName", String.class);
            getName.invoke(instance, "csy");
            System.out.println("方式3 方法反射->" + instance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
