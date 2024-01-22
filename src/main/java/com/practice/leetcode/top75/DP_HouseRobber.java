package com.practice.leetcode.top75;

public class DP_HouseRobber {

	public static void main(String[] args) {
		DP_HouseRobber h = new DP_HouseRobber();
		h.rob(new int [] {1,2,3,1});
	}
	
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int dp [] = new int [nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2 ; i < nums.length; i++) {
        	dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[nums.length-1];
    }
    
}
