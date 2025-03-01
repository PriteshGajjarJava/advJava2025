package com.pga;

public class Student {
	private String name;

	
	public Student(String name) {
		super();
		this.name = name;
	}
	public Student() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void sayHello() {
		System.out.println("Hello - " + this.name);
	}
}
