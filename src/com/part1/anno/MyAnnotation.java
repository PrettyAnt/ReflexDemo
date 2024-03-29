package com.part1.anno;

import static java.lang.annotation.ElementType.CONSTRUCTOR; 
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.part1.bean.People;

/**
 * Created by chenyu. Created on 下午2:40.
 *
 * @interface 用来声明一个注解，其中的每一个方法实际上是声明了一个配置参数。 方法的名称就是参数的名称，返回值类型就是参数的类型。
 *            可以通过default来声明参数的默认值。 在这里可以看到@Retention和@Target这样的元注解，用来声明注解本身的行为。
 * @Retention 用来声明注解的保留策略，有CLASS、RUNTIME和SOURCE这三种， 分别表示注解保存在类文件、JVM运行时刻和源代码中。
 *            只有当声明为RUNTIME的时候，才能够在运行时刻通过反射API来获取到注解的信息。
 * @Target 用来声明注解可以被添加在哪些类型的元素上，如类型、方法和域等。 就可以定义一个注解了，它将自动继承Annotation
 */
@Target({ TYPE, METHOD, FIELD, CONSTRUCTOR, LOCAL_VARIABLE, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	String name() default "测试";
	String value() default "属性";

	int id() default 25;

	Class<? extends People> gid() default People.class;
}
