package com.practice.java8;

import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {
		printEvenNumbersInListFunctional(List.of(1,2,3,4,5));
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
 