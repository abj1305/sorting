package com.practice.java8;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP04BehaviourParameterization {
	
	public static void main(String args []) {
		
		
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		
		filterAndPrint(numbers, x -> x%2 ==0);
		System.out.println("---------------------------------------");
		filterAndPrint(numbers, x -> x%2 !=0);
		System.out.println("---------------------------------------");
		System.out.println(mapAndCreateNewList(numbers, x -> x*x));
		System.out.println("---------------------------------------");
	}

	private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
		numbers.stream()
		.filter(predicate)
		.forEach(System.out :: println);
	}
	
	private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
		return numbers.stream()
		.map(mappingFunction)
		.collect(Collectors.toList());
	}
}
