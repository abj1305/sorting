package com.practice.java8;

import java.util.Arrays;
import java.util.List;

public class FP02Functional {

	public static void main(String[] args) {
		FP02Functional obj = new FP02Functional();
		int sum = obj.addListFunctional(List.of(1,2,3,4,5, 6, 7, 8, 9, 10));
		System.out.println(sum);
	}
	
//	private int sum (int aggregator, int nextNumber) {
//		//System.out.println(aggregator + " " + nextNumber);
////		0 1
////		1 2
////		3 3
////		6 4
////		10 5
////		15 6
////		21 7
////		28 8
////		36 9
////		45 10
////		55
//		return aggregator + nextNumber;
//	}
	
	public int addListFunctional(List<Integer> numbers) {
		//FP02Functional obj = new FP02Functional();
		return numbers.stream()
				//.reduce(0, obj :: sum);
				//.reduce(0, (x,y) -> x+y);
				.reduce(0, Integer::sum);
	}
	
	public int findMaxNumberInAnArray(int [] numbers) {
		return Arrays.stream(numbers).reduce(Integer.MIN_VALUE, (x,y) -> x>y?x:y);
	}
	
	public int findMinNumberInAnArray(int [] numbers) {
		return Arrays.stream(numbers).reduce(Integer.MAX_VALUE, (x,y) -> x<y?x:y);
	}

}
 