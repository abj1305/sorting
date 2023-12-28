package com.practice.questions;

import java.util.Arrays;

public class MinCoinsForChange {

	public static void main(String[] args) {
		int n = minNumberOfCoinsForChange(18, new int [] {7,5,1});
		System.out.println(n);

	}

	public static int minNumberOfCoinsForChange(int n, int[] denoms) {
		int dp [] = new int [n+1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		return helper(n, denoms, dp);
	}
	
	public static int helper(int n, int [] denoms, int [] dp) {
		if(n==0) return 0;
		if(dp[n] != -1) {
			return dp[n];
		}
		int ans = Integer.MAX_VALUE;
		for(int i = 0;i<denoms.length; i++) {
			if(n-denoms[i] >=0) {
				int subAns = helper(n-denoms[i], denoms, dp);
				if(subAns != Integer.MAX_VALUE && subAns + 1 < ans) {
					ans = subAns+1;
				}	
			}
		}
		return dp[n] = ans;
	}

}
