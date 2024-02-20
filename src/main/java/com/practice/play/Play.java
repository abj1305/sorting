package com.practice.play;

import java.util.List;
import java.util.stream.Collectors;

public class Play {

	public static void main(String args[]) {
		List<String> list1 = List.of("Monday", "Tuesday", "Wednesday", "Thursday");
		List<String> list2 = List.of("Wednesday", "Thursday", "Friday");
		
		List <String>list3 = list1.stream().filter(p -> list2.stream().anyMatch(q -> q.equals(p))).collect(Collectors.toList());
		System.out.println(list3);
	
		
	
	}
	
}
