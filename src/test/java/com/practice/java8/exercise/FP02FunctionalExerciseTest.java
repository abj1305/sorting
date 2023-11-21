package com.practice.java8.exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FP02FunctionalExerciseTest {
	
	FP02FunctionalExercise obj;
	List<Integer> numbers = new ArrayList<Integer>();
	
	@BeforeEach
	public void setUp() { 
		obj = new FP02FunctionalExercise(); 	
    } 
	
	
	@Test
	public void squareSum_basic() {
		numbers = List.of(1,2,3,4);
		int actual = obj.squareSum(numbers);
		int expected = 30;
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void squareSum_oneElement() {
		numbers = List.of(1);
		int actual = obj.squareSum(numbers);
		int expected = 1;
		assertEquals(expected, actual);
	}
	
	@Test
	public void squareSum_noElement() {
		int actual = obj.squareSum(numbers);
		int expected = 0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void cubeSum_basic() {
		numbers = List.of(1,2,3,4);
		int actual = obj.cubeSum(numbers);
		int expected = 100;
		assertEquals(expected, actual);
	}
	
	@Test
	public void cubeSum_oneElement() {
		numbers = List.of(1);
		int actual = obj.cubeSum(numbers);
		int expected = 1;
		assertEquals(expected, actual);
	}
	
	@Test
	public void cubeSum_noElement() {
		int actual = obj.cubeSum(numbers);
		int expected = 0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void sumOfOddNumbers_basic() {
		numbers = List.of(1,2,3,4);
		int actual = obj.sumOfOddNumbers(numbers);
		int expected = 4;
		assertEquals(expected, actual);
	}
	
	@Test
	public void sumOfOddNumbers_oneElement() {
		numbers = List.of(1);
		int actual = obj.sumOfOddNumbers(numbers);
		int expected = 1;
		assertEquals(expected, actual);
	}
	
	@Test
	public void sumOfOddNumbers_noElement() {
		int actual = obj.sumOfOddNumbers(numbers);
		int expected = 0;
		assertEquals(expected, actual);
	}
	

}
