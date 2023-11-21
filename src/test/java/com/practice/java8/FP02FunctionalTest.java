package com.practice.java8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class FP02FunctionalTest {

	@Test
	public void addListFunctionalTest_basic() {
		FP02Functional obj = new FP02Functional();
		int result = obj.addListFunctional(List.of(1,2,3,4,5,6,7,8,9,10));
		int expected = 55;
		assertEquals(expected, result);
	}
	
	@Test
	public void addListFunctionalTest_emptyList() {
		FP02Functional obj = new FP02Functional();
		int result = obj.addListFunctional(List.of());
		int expected = 0;
		assertEquals(expected, result);
	}
	
	@Test
	public void addListFunctionalTest_singleElement() {
		FP02Functional obj = new FP02Functional();
		int result = obj.addListFunctional(List.of(10));
		int expected = 10;
		assertEquals(expected, result);
	}
	
	@Test
	public void findMaxNumberInAnArrayTest_basic() {
		FP02Functional obj = new FP02Functional();
		int actual = obj.findMaxNumberInAnArray(new int [] {1,2,3,4,5,6,7,8,9,10});
		int expected = 10;
		assertEquals(expected, actual);
	}
	
	@Test
	public void findMaxNumberInAnArrayTest_singleElement() {
		FP02Functional obj = new FP02Functional();
		int actual = obj.findMaxNumberInAnArray(new int [] {1});
		int expected = 1;
		assertEquals(expected, actual);
	}
	
	@Test
	public void findMaxNumberInAnArrayTest_NoElement() {
		FP02Functional obj = new FP02Functional();
		int actual = obj.findMaxNumberInAnArray(new int [] {});
		int expected = Integer.MIN_VALUE;
		assertEquals(expected, actual);
	}
	
	@Test
	public void findMinNumberInAnArrayTest_basic() {
		FP02Functional obj = new FP02Functional();
		int actual = obj.findMinNumberInAnArray(new int [] {1,2,3,4,5,6,7,8,9,10});
		int expected = 1;
		assertEquals(expected, actual);
	}
	
	@Test
	public void findMinNumberInAnArrayTest_singleElement() {
		FP02Functional obj = new FP02Functional();
		int actual = obj.findMaxNumberInAnArray(new int [] {1});
		int expected = 1;
		assertEquals(expected, actual);
	}
	
	@Test
	public void findMinNumberInAnArrayTest_NoElement() {
		FP02Functional obj = new FP02Functional();
		int actual = obj.findMinNumberInAnArray(new int [] {});
		int expected = Integer.MAX_VALUE;
		assertEquals(expected, actual);
	}
	
}
