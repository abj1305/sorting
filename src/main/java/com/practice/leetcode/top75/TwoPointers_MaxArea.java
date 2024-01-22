package com.practice.leetcode.top75;

public class TwoPointers_MaxArea {
	
	public static void main(String args) {
		
	}
	
    public int maxArea(int[] height) {
    	int l = 0;
    	int r = height.length-1;
    	int max = 0;
    	while(l < r) {
    		max = max(max, min(height[l], height[r]) * (r-l));
    		if(height[l] > height[r]) {
    			r--;
    		}
    		else {
    			l++;
    		}
    	}
    	return max;
    }
    private int min(int x, int y) {
    	return x<y ? x : y;
    }
    private int max(int x, int y) {
    	return x>y ? x : y;
    }
}
