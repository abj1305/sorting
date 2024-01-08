package com.practice.leetcode.top150;

public class RemoveDuplicates_3 {

	public static void main(String args []) {
		
	}
	
    public int removeDuplicates(int[] nums) {
        int l = 0; 
        for(int r = 1; r < nums.length ; r++) {
        	if(nums[r] != nums[r-1]) {
        		nums[++l] = nums[r];
        	}
        }
        return l+1;
    }
	
}
