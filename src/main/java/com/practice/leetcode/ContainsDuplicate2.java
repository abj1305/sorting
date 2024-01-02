package com.practice.leetcode;

import java.util.Arrays;

public class ContainsDuplicate2 {

	
	//https://leetcode.com/problems/contains-duplicate-ii/
	public static void main(String[] args) {
		
		ContainsDuplicate2 c = new ContainsDuplicate2();
		c.containsNearbyDuplicate(new int[]{99,99}, 2);
		
	}
	
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	long distinct = Arrays.stream(nums).distinct().count();
    	if(distinct == nums.length) {
    		return false;
    	}
        for(int i = 0; i < nums.length;i++) {
        	for(int j = i+1;j<=i+k && j<nums.length;j++) {
        		if(nums[i] == nums[j]) {
        			return true;
        		}
        	}
        }
        return false;
    }

}
