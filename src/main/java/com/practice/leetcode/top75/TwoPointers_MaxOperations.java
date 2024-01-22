package com.practice.leetcode.top75;

import java.util.Arrays;

public class TwoPointers_MaxOperations {
	public static void main(String args []) {
		TwoPointers_MaxOperations m = new TwoPointers_MaxOperations();
		m.maxOperations(new int [] {1,2,3,4}, 5);
	}
	
    public int maxOperations(int[] nums, int k) {
    	Arrays.sort(nums);
    	int l = 0; 
    	int r = nums.length-1;
    	int ans=0;
    	while(l<r) {
    		int cur = nums[l]+nums[r];
    		if(cur > k) {
    			r--;
    		}
    		else if(cur < k) {
    			l++;
    		}
    		else {
    			l++;
    			r--;
    			ans++;
    		}
    	}
    	return ans;
    }
}
