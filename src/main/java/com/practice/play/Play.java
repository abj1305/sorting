package com.practice.play;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Play {

	public static void main(String args[]) {
		List<String> list1 = List.of("Monday", "Tuesday", "Wednesday", "Thursday");
		List<String> list2 = List.of("Wednesday", "Thursday", "Friday");
		
		List <String>list3 = list1.stream().filter(p -> list2.contains(p)).collect(Collectors.toList());
		System.out.println(list3);
		
		List<Integer> list = List.of(2,1,4,3,7,-1);
		System.out.println(
				list.stream().mapToInt(Integer :: intValue).min().getAsInt()
				);
		
		System.out.println(
				list1.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList())
				);
		

	
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