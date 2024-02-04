package com.practice.leetcode;

public class MaxSumAfterPartitioning {

	public static void main(String[] args) {
		MaxSumAfterPartitioning m = new MaxSumAfterPartitioning();
		m.maxSumAfterPartitioning(new int [] {1,15,7,9,2,5,10}, 3);

	}

	public int maxSumAfterPartitioning(int[] arr, int k) {
        int N = arr.length;

        int[] dp = new int[N + 1];

        for (int start = N - 1; start >= 0; start--) {
            int currMax = 0;
            int end = Math.min(N, start + k);

            for (int i = start; i < end; i++) {
                currMax = Math.max(currMax, arr[i]);
                dp[start] = Math.max(dp[start], dp[i + 1] + currMax * (i - start + 1));
            }
        }
        return dp[0];
    }
	
}
