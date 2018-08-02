package com.wb;

public class People  implements Runnable{
	private String name="baobei";
	private int age=18;
	public String love="cy";
	
	public People() {
		super();
	}
	public People(String name) {
		super();
		this.name = name;
	}
	public People(int age) {
		super();
		this.age = age;
	}
	public People(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public void run() {
		System.out.println("敲代码...");
	}
	@Override
	public String toString() {
		return "People [name=" + name + ", age=" + age + "]";
	}
	
}
