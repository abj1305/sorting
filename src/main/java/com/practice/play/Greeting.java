package com.practice.play;

@FunctionalInterface
public interface Greeting {

	public void greet();
	
	default public void method1() {
		System.out.println("In Greeting default class");
	}
	
	static public void method2() {
		System.out.println("In Greeting Static class");
	}
}
