package com.practice.play;



public class Test1 {

	public static void print (Greeting greetint) {
		greetint.greet();
	}
	
	public static void main(String[] args) {
		System.out.format("%.3f is my favourite no", 3.1238);
		print(() -> System.out.println("Hello"));
		Greeting.method2();
		Greeting g = new GreetingChild();
		g.method1();
	}

}
