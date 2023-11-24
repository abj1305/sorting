package com.practice.java8;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;

	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public String toString() {
		return name + ": " + noOfStudents + ": " + reviewScore;
	}


}

public class FP05CustomClass {

	public static void main(String [] args) {
		List<Course> courses =
				List.of(
						new Course("Spring", "Framework", 98, 20000),
						new Course("Spring Boot", "Framework", 95, 18000),
						new Course("API", "Microservices", 97, 22000),
						new Course("Microservices", "Microservices", 96, 25000),
						new Course("FullStack", "FullStack", 92, 14000),
						new Course("AWS", "Cloud", 99, 21000),
						new Course("Azure", "Cloud", 91, 21000),
						new Course("Docker", "Cloud", 92, 20000),
						new Course("Kubernates", "Cloud", 96, 20000)
						);


		// allMatch
		Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;
		Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;
		Predicate<Course> reviewScoreGreaterThan99Predicate = course -> course.getReviewScore() > 99;

		System.out.println(courses.stream().allMatch(reviewScoreGreaterThan90Predicate));

		// noneMatch
		System.out.println(courses.stream().noneMatch(reviewScoreGreaterThan99Predicate));
		// anyMatch
		System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan95Predicate));

		Comparator<Course> comparingByNoOfStudents = new Comparator<Course>() {
			@Override
			public int compare(Course o1, Course o2) {
				return o1.getNoOfStudents() - o2.getNoOfStudents();
			}
		};

		//courses.stream().sorted((Course c1, Course c2) -> c1.getNoOfStudents() - c2.getNoOfStudents()).forEach(System.out :: println);

		Comparator<Course> comparingByNoOfStudentsAndRewiewScore = Comparator.comparing(Course::getNoOfStudents).reversed().thenComparing(Course :: getReviewScore);		
 
		
		System.out.println(
				courses.stream().sorted(comparingByNoOfStudentsAndRewiewScore).collect(Collectors.toList())
				);
		
		
		System.out.println(
				courses.stream().sorted(comparingByNoOfStudentsAndRewiewScore).limit(5).collect(Collectors.toList())
				);
		
		System.out.println(
				courses.stream().sorted(comparingByNoOfStudentsAndRewiewScore).skip(3).collect(Collectors.toList())
				);
		
		System.out.println(
				courses.stream().sorted(comparingByNoOfStudentsAndRewiewScore).takeWhile(course -> course.getReviewScore()>=95).collect(Collectors.toList())
				);
		
		System.out.println(
				courses.stream().sorted(comparingByNoOfStudentsAndRewiewScore).dropWhile(course -> course.getReviewScore()>=95).collect(Collectors.toList())
				);
		
		System.out.println(
				courses.stream().min(comparingByNoOfStudentsAndRewiewScore)
				);
		
		System.out.println(
				courses.stream().max(comparingByNoOfStudentsAndRewiewScore)
				);
		
		
		Predicate<Course> courseWithStudentsMoreThan20000Predicate = course -> course.getNoOfStudents()>20000;
		System.out.println(
				courses.stream().filter(courseWithStudentsMoreThan20000Predicate).findFirst()
				);
		
		System.out.println(
				courses.stream().filter(courseWithStudentsMoreThan20000Predicate).findAny()
				);
		
		System.out.println(
				courses.stream().filter(courseWithStudentsMoreThan20000Predicate).collect(Collectors.toList())
				);
		
		List<Integer> numbers = List.of(1,10,2,9,3,8,4,7,5,6);
		
		System.out.println(
				numbers.stream().filter(number -> number%2 ==0).mapToInt(number -> (int)number).sum()
				);
		
		System.out.println(
				numbers.stream().filter(number -> number%2 ==0).mapToInt(number -> (int)number).average().orElse(0)
				);
		
		System.out.println(
				numbers.stream().filter(number -> number%2 ==0).max((a, b) -> a-b).orElse(0)
				);
		
		System.out.println(
				numbers.stream().filter(number -> number%2 != 0).min((a, b) -> a-b).orElse(0)
				);

		System.out.println(
				numbers.stream().filter(number -> number%2 != 0).count()
				);
		
		// get second biggest number 
		System.out.println(
				numbers.stream().sorted((a, b) -> b-a).skip(1).findFirst().orElse(0)
				);
		
		System.out.println(
				courses.stream().collect(Collectors.groupingBy(Course :: getCategory))
				);
		
		System.out.println(
				courses.stream().collect(Collectors.groupingBy(Course :: getCategory, Collectors.counting())));
		

	}

}
