package com.practice.java8;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

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
		
		// ******** Some more Functional Interfaces ***** //
		
		//Supplier -> takes no input and give one output
		Supplier<Integer> randomNumberSupplier = () -> (int)(Math.random()*100);
		System.out.println(randomNumberSupplier.get());
		System.out.println("---------------------------------------");
		
		//BinaryOperator -> takes 2 input and give one output
		BinaryOperator<Integer> binaryOp = (x,y) -> x+y;
		System.out.println(binaryOp.apply(1, 5));
		System.out.println("---------------------------------------");
		
		//UnaryOperator -> takes 1 input and give one output
		UnaryOperator<Integer> unaryOp = (y) -> y + y;
		System.out.println(unaryOp.apply(10));
		System.out.println("---------------------------------------");
		
		//BiPredicate
		BiPredicate<Integer, String> biPredicate = (number, string) -> {
			String str = String.valueOf(number);
			return str.equals(string);
		};
		System.out.println(biPredicate.test(25, "25"));
		System.out.println("---------------------------------------");
		
		//BiFunction
		BiFunction<Integer, String, String> biFunction = (number, string) -> {
			String str = string +": " +number;
			return str;
		};
		System.out.println(biFunction.apply(25, "BiFunction"));
		System.out.println("---------------------------------------");
		
		//BiConsumer
		BiConsumer<Integer, String> biConsumer = (number, string) -> {
			System.out.println(string +": " +number);
		};
		biConsumer.accept(25, "BiConsumer");
		System.out.println("---------------------------------------");
	}

}
