package com.practice.leetcode.top150;

public class RemoveDuplicates2_4 {

	public static void main(String args []) {
		RemoveDuplicates2_4 r = new RemoveDuplicates2_4();
		r.removeDuplicates(new int [] {0,0,1,1,1,1,2,3,3});
	}

	public int removeDuplicates(int[] nums) {
        int count=1,i=1;
        for(int j = 1; j < nums.length; j++) {
        	if(count < 2 && nums[j] == nums[j-1]) {
        		nums[i] = nums[j];
        		count ++;
        		i++;
        	}
        	else if(nums[j] != nums[j-1]) {
        		count = 1;
        		nums[i] = nums[j];
        		i++;
        	}
        	
        }
        return i;
    }

}
