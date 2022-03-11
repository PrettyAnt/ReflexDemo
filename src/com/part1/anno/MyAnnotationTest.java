package com.part1.anno;

import com.part1.bean.People;
import com.part1.bean.Student;

/**
 * 测试注解类
 * 
 * @author chenyu
 *
 */
@MyAnnotation(name = "类",id = 18)
public class MyAnnotationTest {
	@MyAnnotation(name = "成员变量", id = 1, gid = Student.class)
	private int age;

	@MyAnnotation(name = "构造方法", id = 2, gid = Student.class)
	public MyAnnotationTest() {

	}

	@MyAnnotation2(name = "MyAnnotation2",gid = People.class)
	@MyAnnotation(name = "MyAnnotation1", id = 3, gid = Student.class)
	public void getName() {
		System.out.println("------my name is wb-------");
	}

	// 方法参数注解
	public void getData(@MyAnnotation(name = "MyAnnotation1", id = 3,value = "值",gid = Student.class) String data,
			@MyAnnotation2(name = "MyAnnotation2", weight = 3, gid = Student.class)int weight) {
		System.out.println("------my name is " + data + "-------");
	}

}
