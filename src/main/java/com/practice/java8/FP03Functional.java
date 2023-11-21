package com.practice.java8;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP03Functional {

	public static void main(String[] args) {
		FP03Functional obj = new FP03Functional();
		obj.printDistinct(List.of(1,2,3,2,1,2,3));
		System.out.println("------------------------------------");
		obj.printSorted(List.of(1,2,3,2,1,2,3));
		System.out.println("------------------------------------");
		obj.printSortedString(List.of("Spring", "Spring boot", "API", "Microservices"));
		System.out.println("------------------------------------");
		obj.printReverseSortedString(List.of("Spring", "Spring boot", "API", "Microservices"));
		System.out.println("------------------------------------");
		obj.printSortedStringByLength(List.of("Spring", "Spring boot", "API", "Microservices"));
		System.out.println("------------------------------------");
		obj.printReverseSortedStringByLength(List.of("Spring", "Spring boot", "API", "Microservices"));
		System.out.println("------------------------------------");
		System.out.println(obj.doubleList(List.of(1,2,3,4,5)));
		System.out.println("----------------------------------------");
		
	}
	
	public void printDistinct(List<Integer> numbers) {
		numbers.stream().distinct().forEach(System.out :: println);
	}
	
	public void printSorted(List<Integer> numbers) {
		numbers.stream().sorted().forEach(System.out :: println);
	}
	
	public void printSortedString(List<String> strings) {
		strings.stream().sorted(Comparator.naturalOrder()).forEach(System.out :: println);
	}
	
	public void printReverseSortedString(List<String> strings) {
		strings.stream().sorted(Comparator.reverseOrder()).forEach(System.out :: println);
	}
	
	public void printSortedStringByLength(List<String> strings) {
		strings.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out :: println);
	}
	
	public void printReverseSortedStringByLength(List<String> strings) {
		strings.stream()
		.sorted((s1, s2) -> s2.length() - s1.length())
		.forEach(System.out :: println);
	}
	
	public List<Integer> doubleList(List<Integer> numbers) {
		return numbers.stream().map(number -> number * number).collect(Collectors.toList());
	}

}
 