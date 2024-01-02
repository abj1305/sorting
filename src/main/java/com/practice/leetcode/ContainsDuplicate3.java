package com.practice.leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/contains-duplicate-iii/
public class ContainsDuplicate3 {

	public static void main(String[] args) {
		ContainsDuplicate3 c = new ContainsDuplicate3();
		c.containsNearbyAlmostDuplicate(new int [] {1,2,3,1}, 3, 0);

	}

	public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
		
		if(valueDiff == 0) {
			long distinct = Arrays.stream(nums).distinct().count();
	    	if(distinct == nums.length) {
	    		return false;
	    	}
		}

		for(int i = 0; i < nums.length ; i++) {
			for(int j = i+1; j <= ( i+indexDiff <= nums.length-1 ?  i+indexDiff : nums.length-1) ; j++) {
				if(Math.abs(nums[i]-nums[j]) <= valueDiff) {
					return true;
				}
			}
		}
		return false;
		
	}

}
