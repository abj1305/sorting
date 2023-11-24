package com.practice.java8;

import java.util.Comparator;
import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {
		printEvenNumbersInListFunctional(List.of(1,2,3,4,5));
		System.out.println("---------------------------------------------");
		List<Integer> numbers = List.of(12,3,43,23,110,15,76);
		System.out.println(numbers.stream().max(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		}).get());
	}
	
	private static void printAllNumbersInListFunctional(List<Integer> list) {
		// Method Reference
		list.stream().forEach(System.out :: println);
	}
	
//	private static boolean isEven(int number) {
//		return number % 2 ==0;
//	}
	
	
	private static void printEvenNumbersInListFunctional(List<Integer> list) {
		// Method Reference
		list.stream()
		//.filter(FP01Functional :: isEven)
		.filter(number -> number%2==0) // lambda expression
		.forEach(System.out :: println); // Method Reference
	}

}
 