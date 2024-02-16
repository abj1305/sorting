package com.practice.leetcode;

public class RearrangeArray {
	
	public static void main(String args[]) {
		RearrangeArray r = new RearrangeArray();
		int [] ans = r.rearrangeArray(new int [] {3,1,-2,-5,2,-4});
		System.out.println(ans);
	}
	
    public int[] rearrangeArray(int[] nums) {
        int [] ans = new int [nums.length];
        int index = 0;
        int p = -1, n = -1;
        while(p == -1  || n == -1 ) {
        	if(p == -1) {
        		if(nums[index] > 0) {
        			p = index++;
        			continue;
        		}
        	}
        	if(n == -1) {
        		if(nums[index] < 0) {
        			n = index++;
        			continue;
        		}
        	}
        	index++;
        }
        for(int i = 0 ; i < nums.length/2; i++) {
        	ans[i*2] = nums[p++];
        	ans[i*2 + 1] = nums[n++];
        	while(p < nums.length && nums[p] < 0) {
        		p++;
        	}
        	while(n < nums.length && nums[n] > 0) {
        		n++;
        	}
        }
        return ans;
    }

}
