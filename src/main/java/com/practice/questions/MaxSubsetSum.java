package com.practice.questions;

public class MaxSubsetSum {

	public static void main(String[] args) {
	
		System.out.println(
				maxSubsetSumNoAdjacent(new int [] {2})
				);

	}

	//https://www.algoexpert.io/questions/max-subset-sum-no-adjacent
	public static int maxSubsetSumNoAdjacent(int[] array) {
		if(array.length == 0) {
			return 0;
		}
		if(array.length == 1) {
			return array[0];
		}
		int second = array[0];
		int first = Integer.max(second, array[1]);
		int max = Integer.max(second, first);
		
		for(int i=2;i<array.length;i++) {
			max = Integer.max(first, second + array[i]);
			second = first;
			first = max;
		}
		
	    return max;
	  }
	
}
