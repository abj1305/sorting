package com.practice.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FP06FunctionalFlatMap {
	
	public static void main(String args []) {
		
		List<String> courses = List.of("Spring", "Spring boot", "API", "Microservices");
		List<String> coursess = List.of("Spring2", "Spring boot2", "API2", "Microservices2");
		
		List<List<String>> allCoursesList = new ArrayList<>();
		allCoursesList.add(courses);
		allCoursesList.add(coursess);
		
		System.out.println(
				allCoursesList.stream().flatMap(coursesList -> coursesList.stream()).collect(Collectors.toList())
				);
	}
	
}
