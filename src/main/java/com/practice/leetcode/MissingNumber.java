package com.practice.leetcode;

public class MissingNumber {

	public static void main(String args[]) {
		MissingNumber m = new MissingNumber();
		m.missingNumber(new int[] {1,0,3});
	}
	
    public int missingNumber(int[] nums) {
    	int n = nums.length;
    	int expectedSum = (n * (n+1)) / 2;
    	
        for(int i : nums) {
        	expectedSum -= i;
        }
        return expectedSum;
    }
	
}
