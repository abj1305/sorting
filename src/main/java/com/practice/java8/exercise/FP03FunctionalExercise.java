package com.practice.java8.exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP03FunctionalExercise {

	public static void main(String [] args) {
		
		List<Integer> numbers = List.of(1,2,3,4,5);
		FP03FunctionalExercise obj = new FP03FunctionalExercise();
		System.out.println(obj.listOfAllOddNumbers(numbers));
		System.out.println("------------------------------------");
		System.out.println(obj.listOfLengthOfString(List.of("Spring", "Spring boot", "API", "Microservices")));
		System.out.println("------------------------------------");
		System.out.println(obj.listOfLengthOfSortedString(List.of("Spring", "Spring boot", "API", "Microservices")));
		
		
	}

	public List<Integer> listOfAllOddNumbers(List<Integer> numbers) {
		return numbers.stream().filter(number -> number%2==1).collect(Collectors.toList());
	}
	
	public List<String> listOfLengthOfString(List<String> strings) {
		return strings.stream().map(str -> (str + ": " +str.length())).collect(Collectors.toList());
	}
	
	public List<String> listOfLengthOfSortedString(List<String> strings) {
		return strings.stream()
				.sorted(Comparator.comparing(str -> str.length()))
				.map(str -> (str + ": " +str.length()))
				.collect(Collectors.toList());
	}

}
