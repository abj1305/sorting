package com.practice.play;

import java.util.List;
import java.util.stream.Collectors;

public class Play {

	public static void main(String args[]) {
		List<String> list1 = List.of("Monday", "Tuesday", "Wednesday", "Thursday");
		List<String> list2 = List.of("Wednesday", "Thursday", "Friday");
		
		List <String>list3 = list1.stream().filter(p -> list2.contains(p)).collect(Collectors.toList());
		System.out.println(list3);

	
	}
	
}


class Parent {
	public void method() {
		System.out.println("parent method");
	}
}

class Child extends Parent {
	public void method() {
		System.out.println("child method");
	}
	
	public void function() {
		System.out.println("child function");
	}
}