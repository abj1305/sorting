package com.practice.leetcode.top150;

public class RotateArray {

	public static void main(String[] args) {

		RotateArray r = new RotateArray();
		int [] array = new int [] {1,2,3,4,5,6,7};
		r.rotate(array, 1);
		System.out.println(array);
		
	}

    public void rotate(int[] nums, int k) {
    	if(k%nums.length == 0) {
    		return;
    	}
    	
    	k = k%nums.length;
    	int array [] = new int [nums.length];
    	for(int i = 0 ; i < nums.length ; i++) {
    		array[i] = nums[i];
    	}
    	for(int i = 0 ; i < nums.length ; i++) {
    		nums[(i+k)%nums.length] = array[i];
    	}
    }
}
