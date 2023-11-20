package com.practice.java8.exercise;

import java.util.List;

public class FP01FunctionalExercise {

	public static void main(String [] args) {

		printAllOddNumbers(List.of(1,2,3,4,5,6,7,8,9));
		System.out.println("--------------------------");
		printSquareOfAllOddNumbers(List.of(1,2,3,4,5,6,7,8,9));
		System.out.println("--------------------------");
		printAllCourses(List.of("Spring", "Spring boot", "API", "Microservices"));
		System.out.println("--------------------------");
		printCoursesContainingSpring(List.of("Spring", "Spring boot", "API", "Microservices"));
		System.out.println("--------------------------");
		printCoursesWithAtleast4Words(List.of("Spring", "Spring boot", "API", "Microservices"));
		System.out.println("--------------------------");
		printNoOfCharactersinEachCourse(List.of("Spring", "Spring boot", "API", "Microservices"));
		System.out.println("--------------------------");

	}

	public static void printAllOddNumbers(List<Integer> numbers) {
		numbers.stream()
		.filter(number -> number%2==1)
		.forEach(System.out :: println);
	}
	
	public static void printSquareOfAllOddNumbers(List<Integer> numbers) {
		numbers.stream()
		.filter(number -> number%2==1)
		.map(x -> x*x)
		.forEach(System.out :: println);
	}
	
	public static void printAllCourses(List<String> courses) {
		courses.stream().forEach(System.out :: println);
	}
	
	public static void printCoursesContainingSpring(List<String> courses) {
		courses.stream().filter(course -> course.contains("Spring")).forEach(System.out :: println);
	}
	
	public static void printCoursesWithAtleast4Words(List<String> courses) {
		courses.stream().filter(course -> course.length() >= 4).forEach(System.out :: println);
	}
	
	private static void printNoOfCharactersinEachCourse(List<String> courses) {
		courses.stream().map(course -> course + " " +course.length()).forEach(System.out :: println);
	}

}
