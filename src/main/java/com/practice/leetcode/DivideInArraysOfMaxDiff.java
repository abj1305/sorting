package com.practice.leetcode;

import java.util.Arrays;

public class DivideInArraysOfMaxDiff {

	public static void main(String[] args) {
		DivideInArraysOfMaxDiff d = new DivideInArraysOfMaxDiff();
		d.divideArray(new int[] {1,3,3,2,7,3}, 3);
	}
	
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans [][] = new int [nums.length/3][3];
        for(int i = 0 ; i < nums.length; i = i + 3) {
        	if(nums[i+2] - nums[i] > k) {
        		return new int[0][0];
        	}
        	ans[i/3] = new int [] {nums[i], nums[i+1], nums[i+2]};
        }
        return ans;
    }
}
