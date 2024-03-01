package com.practice.questions;

public class MaxSubsetSumNoAdjacent {

	public static void main(String[] args) {

		System.out.println(
				maxSubsetSumNoAdjacent(new int [] {75,105, 120, 75, 90, 135})
				);

	}

	//https://www.algoexpert.io/questions/max-subset-sum-no-adjacent
	public static int maxSubsetSumNoAdjacent(int[] array) {		
		int n = array.length;
		if(n == 0) return 0;
		if(n==1) return array[0];
		int [] dp = new int [n];
		dp[0] = array[0];
		dp[1] = Math.max(array[0], array[1]);
		for(int i = 2 ; i < n; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2]+array[i]);
		}
		return dp[n-1];
	}

}
