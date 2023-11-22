package com.practice.java8;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP04FunctionalInterfaces {
	
	public static void main(String args []) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		
		
		Predicate<Integer> isEvenPredicate = x -> x%2 ==0;
		Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
			@Override
			public boolean test(Integer x) {
				return x%2==0;
			}
		};
		
		Function<Integer,Integer> squareMethod = x -> x*x;
		Function<Integer,Integer> squareMethod2 = new Function<Integer, Integer>() {
			
			@Override
			public Integer apply(Integer x) {
				return x*x;
			}
		};
		
		Consumer<Integer> printConsumer = System.out::println;
		Consumer<Integer> printConsumer2 = new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		};
		
		
		numbers.stream()
		.filter(isEvenPredicate)
		.map(squareMethod)
		.forEach(printConsumer);
		
		System.out.println("-----------------------------------------");

		numbers.stream()
		.filter(isEvenPredicate2)
		.map(squareMethod2)
		.forEach(printConsumer2);
		
		System.out.println("-----------------------------------------");
		
		BinaryOperator<Integer> sumBinaryOperator = Integer :: sum;
		BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer accumulator, Integer nextInt) {
				return accumulator + nextInt;
			}
		};
		
		
		System.out.println(numbers.stream()
				.reduce(0, sumBinaryOperator));
		
		System.out.println("-----------------------------------------");
		System.out.println(numbers.stream()
				.reduce(0, sumBinaryOperator2));
		System.out.println("-----------------------------------------");		
		
		
	}

}
