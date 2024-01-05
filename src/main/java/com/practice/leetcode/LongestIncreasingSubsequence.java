package com.practice.leetcode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		
		LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
		l.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18});

	}

	public int lengthOfLIS(int[] nums) {
		if(nums.length == 0) return 0;
		int [] dp = new int [nums.length];
		Arrays.fill(dp, 1);
		for(int i = 1 ; i<nums.length ; i++) {
			for(int j = 0; j < i ; j++) {
				if(nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		int maxLength = Arrays.stream(dp).max().orElse(0);
		return maxLength;
	}

}
