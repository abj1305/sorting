package com.practice.leetcode;

public class EasyBinarySearch {

	public static void main(String[] args) {
		int [] nums = new int [] {5};
		EasyBinarySearch e = new EasyBinarySearch();
		e.search(nums, 5);
	}
	
    public int search(int[] nums, int target) {
        return binarySearch(0, nums.length-1, nums, target);
    }
    
    public int binarySearch(int l, int r, int [] nums, int target) {
    	int mid = (l + r)/2;
    	
    	if(r<l || (target < nums[l] && target > nums[r])) {
    		return -1;
    	}
        if(nums[mid] == target) {
    		return mid;
    	}
    	if(nums[mid] < target) {
    		return binarySearch(mid+1, r, nums, target);
    	}
    	else {
    		return binarySearch(l, mid-1, nums, target);
    	}
    }
}
