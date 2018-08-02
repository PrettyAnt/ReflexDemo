package com.wb;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.wb.anno.MyAnnotation;
import com.wb.anno.MyAnnotation2;
import com.wb.anno.MyAnnotationTest;

public class FanSheDemo {
	// private static final Annotation MyAnnotation = null;

	public static void main(String[] args) {
		// Student test = new Student();
		// Class<? extends People> clazz = test.getClass();
		Class<?> clazz = null;
		People people = new People();
		try {
			clazz = Class.forName("com.wb.Student");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		// --------------------包名、类名------------------------
		System.out.println("--------------------包名、类名------------------------");
		System.out.println("类名name:" + clazz.getName());
		System.out.println("包名: " + clazz.getPackage());
		System.out.println("父类：" + clazz.getSuperclass());
		System.out.println("父类是不是抽象类：" + Modifier.isAbstract(clazz.getModifiers()));
		System.out.println("父类实现的接口：" + clazz.getSuperclass().getInterfaces()[0]);

		// --------------------构造器------------------------
		System.out.println("\n\n--------------------构造器------------------------");
		Constructor<?>[] constructors = clazz.getSuperclass().getConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println("父类的构造器:" + constructor.toString());
		}
		// 拿到构造方法
		Constructor<?> constructor = null;
		try {
			constructor = clazz.getSuperclass().getConstructor(String.class, int.class);
			System.out.println("构造器方法:" + constructor.toString());
			// 使用constructor创造对象
			Object newInstance = constructor.newInstance("wangbei", 24);
			System.out.println("得到的结果" + newInstance.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// --------------------变量------------------------
		System.out.println("\n\n===============$只能拿到公有的变量或方法$==============="
				+ "\n--------------------变量------------------------");
		// 遍历方式获取
		Field[] fields = clazz.getSuperclass().getFields();
		for (Field field : fields) {
			System.out.println("变量为:" + field.toString() + "\n变量名:" + field.getName());
		}
		// 指定方式获取
		Field field = null;
		try {
			field = clazz.getSuperclass().getField("love");
			System.out.println("变量为:" + field.toString() + "\n变量名:" + field.getName());
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			// 未更改前
			System.out.println("1.初始化姓名:" + people.getName());
			// 通过直接更改字段方式更改
			Field declaredField = people.getClass().getDeclaredField("name");
			declaredField.setAccessible(true);
			declaredField.set(people, "chenyu");
			System.out.println("2.姓名:" + people.getName());

			// 通过set方法更改姓名
			Method method = people.getClass().getMethod("setName", String.class);
			method.invoke(people, "wangbei");
			System.out.println("3.姓名:" + people.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// --------------------方法------------------------
		System.out.println("\n\n--------------------方法------------------------");
		Method[] methods = people.getClass().getMethods();
		for (Method method : methods) {
			System.out.println("--方法--:" + method.getName());
		}
		try {
			Method method = people.getClass().getMethod("setAge", int.class);
			// 返回值类型
			System.out.println("方法名为:" + method.getName() + "" + "\n返回值类型为:" + method.getReturnType());
			// method.invoke(people.getClass().newInstance(), 3);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// --------------------私有变量、私有方法------------------------
		System.out.println("\n\n===============$私有变量或私有方法$===============" + "\ngetDeclaredFields()"
				+ "\ngetDeclaredMethods()" + "\ngetDeclaredField(变量名)" + "\ngetDeclaredMethod(方法名)"
				+ "\n必须让这些对象调用setAccessible(true)才能调用");

		// getDeclaredFields与getDeclaredMethods方法得到私有的变量与方法，
		// 同样也支持用getDeclaredField（变量名）与getDeclaredMethod（方法名)的形式得到指定的变量名与方法名。
		// 但是这样得到的Field对象与Method对象无法直接运用，必须让这些对象调用setAccessible(true),才能正常运用

		// --------------------注解------------------------
		System.out.println("\n\n===============$注解$===============");
		MyAnnotationTest myAnnotationTest = new MyAnnotationTest();
		Class<? extends MyAnnotationTest> class1 = myAnnotationTest.getClass();
		// 获取类的注解的数组
		Annotation[] annotations2 = class1.getAnnotations();
		for (Annotation ann : annotations2) {
			if (ann instanceof MyAnnotation) {
				MyAnnotation ann2 = (MyAnnotation) ann;
				System.out.println("注解测试：" + ann2.name() + "---" + ann2.id() + "---" + ann2.gid());
			}
		}
		// 直接获取类的指定的注解
		MyAnnotation annotation = class1.getAnnotation(MyAnnotation.class);
		int id = annotation.id();
		Class<? extends People> gid = annotation.gid();
		String name = annotation.name();
		System.out.println("注解测试：" + name + "---" + id + "---" + gid.toString());

		try {
			// 直接获取方法的指定的注解
			Method method = myAnnotationTest.getClass().getMethod("getName");
			Annotation[] annotations4 = method.getAnnotations();
			System.out.println("\n·················\n" + annotations4[0] + "\n");
			MyAnnotation annotation2 = method.getAnnotation(MyAnnotation.class);
			if (annotation2 instanceof MyAnnotation) {
				System.out.println("注解测试：" + annotation2.name() + "---" + annotation2.id() + "---" + annotation2.gid());

			}
			System.out.println("\n-----------------------");
			// 获取指定方法的注解的数组
			Annotation[] annotations = method.getAnnotations();
			for (Annotation annotation1 : annotations) {
				if (annotation1 instanceof MyAnnotation) {
					System.out.println("MyAnnotation1:" + ((MyAnnotation) annotation1).name() + "---"
							+ ((MyAnnotation) annotation1).id() + "---" + ((MyAnnotation) annotation1).gid());
				} else if (annotation1 instanceof MyAnnotation2) {
					System.out.println("MyAnnotation2:" + ((MyAnnotation2) annotation1).name() + "---"
							+ ((MyAnnotation2) annotation1).weight() + "---" + ((MyAnnotation2) annotation1).gid());
				}
			}
			System.out.println("\n-----------------------");
			// 方法参数的注解
			Method method2 = myAnnotationTest.getClass().getMethod("getData", String.class, int.class);
			Annotation[][] parameterAnnotations = method2.getParameterAnnotations();
			for (Annotation[] paprameter : parameterAnnotations) {
				for (Annotation anno : paprameter) {
					// System.out.println(anno+"\n\n");
					if (anno instanceof MyAnnotation) {
						System.out.println(((MyAnnotation) anno).name());
					} else if (anno instanceof MyAnnotation2) {
						System.out.println(((MyAnnotation2) anno).name());
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error:" + e.toString());
		}
		// ===============$数组$===============
		System.out.println("\n===============$数组$===============");
		Class<int[]> clazz1 = int[].class;
		
		System.out.println(clazz1.getTypeName());
		try {
//			int[] instance = clazz1.newInstance();
//			System.out.println("数组长:"+instance.length);
			// 创建一个int类型的数组，长度为4；
//			int[] intArray = (int[]) Array.newInstance(int.class, 4);
			String[] intArray=new String[4];
			//通过反射形式，给数组赋值
			for (int i = 0; i < intArray.length; i++) {
				Array.set(intArray, i, "wangbei"+i);
			}
			//通过反射形式，得到数组中的值
			for (int i = 0; i < intArray.length; i++) {
				System.out.println("反射后数组:" + Array.get(intArray, i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		/**
		 		
		 
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
		*/
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
}