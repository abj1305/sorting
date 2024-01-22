package com.practice.leetcode.top75;

public class TwoPointers_MoveZeros {
	
	public static void main(String args []) {
		TwoPointers_MoveZeros m = new TwoPointers_MoveZeros();
		m.moveZeroes(new int [] {1,2,3,0,3,0,2});
	}
	
    public void moveZeroes(int[] nums) {
    	int slow=0;
    	for(int i = 0; i < nums.length; i++) {
    		if(nums[i] !=0) {
    			nums[slow++] = nums[i];
    		}
    	}
    	while(slow < nums.length) {
    		nums[slow++] = 0;
    	}
    }
}
