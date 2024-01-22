package com.practice.leetcode;

import java.util.Arrays;

public class ClimbingStairss {

	static int dp [] = new int [0];
    public int climbStairss(int n) {
    	if(n < 2) return 1;
        dp = new int [n+1];
        Arrays.fill(dp, -1);
        dp[1] = 1;
        dp[2] = 2;
        return climbStairsss(n);
    }
    // memoization
    private int climbStairsss(int n) {
    	if(dp[n]!=-1) return dp[n];
    	dp[n] = climbStairss(n-1) + climbStairss(n-2);
    	return dp[n];
    }
    
    //tabulation
    private int climbStairssss(int n) {
    	if(n < 2) return 1;
    	int dp [] = new int[n+1];
    	dp[0] = 0;
    	dp[1] = 1;
    	dp[2] = 2;
    	for(int i = 3; i <= n;i++) {
    		dp[i] = dp[i-1] + dp[i-2];
    	}
    	return dp[n];
    }
    
    private int climbStairs(int n) {
    	if(n < 2) return 1;
    	if(n == 2) return 2;
    	int prev = 1;
    	int cur = 2;
    	for(int i = 3; i <= n;i++) {
    		int tmp = cur;
    		cur = cur + prev;
    		prev = tmp;
    	}
    	return cur;
    }
}
