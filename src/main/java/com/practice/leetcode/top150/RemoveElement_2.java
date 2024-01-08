package com.practice.leetcode.top150;

public class RemoveElement_2 {

	public static void main(String[] args) {

	}
	
    public int removeElement(int[] nums, int val) {
    	int end = nums.length-1;
    	int start = 0;
    	while(start<=end) {
    		while(start <= end && nums[end] == val) {
    			end --;
    		}
    		if(end < start) {
    			continue;
    		}
    		if(nums[start] == val) {
    			int tmp = nums[end];
    			nums[end] = nums[start];
    			nums[start] = tmp;
    			start ++;
    			end --;
    		}
    		else {
    			start++;
    		}
    	}
    	return start;
    }

}
