package com.practice.java8.exercise;

import java.util.List;

public class FP02FunctionalExercise {

	public static void main(String [] args) {
		
		List<Integer> numbers = List.of(1,2,3,4,5);
		FP02FunctionalExercise obj = new FP02FunctionalExercise();
		
		System.out.println("--------------------------");
		System.out.println(obj.squareSum(numbers));
		System.out.println("--------------------------");
		System.out.println(obj.cubeSum(numbers));
		System.out.println("--------------------------");
		System.out.println(obj.sumOfOddNumbers(numbers));
		System.out.println("--------------------------");
	}

	public int squareSum(List<Integer> numbers) {
		return numbers.stream().map( number -> number*number).reduce(0, (x,y) -> x+y);
	}
	
	public int cubeSum(List<Integer> numbers) {
		return numbers.stream().map( number -> number*number*number).reduce(0, (x,y) -> x+y);
	}
	
	public int sumOfOddNumbers(List<Integer> numbers) {
		return numbers.stream().filter( number -> number%2 ==1).reduce(0, (x, y) -> x+y);
	}

}
