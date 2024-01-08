package com.practice.leetcode.top150;


//https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
public class MergeSortedArray_1 {

	public static void main(String[] args) {
		MergeSortedArray_1 m = new MergeSortedArray_1();
		m.merge(new int [] {0}, 0, new int [] {1}, 1);

	}

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int t = m+n-1;
        m = m-1;
        n = n-1;
        while(t>=0 && m >=0 && n>=0) {
        	if(nums1[m] > nums2[n]) {
        		nums1[t--] = nums1[m--];
        	}
        	else {
        		nums1[t--] = nums2[n--];
        	}
        }
        if(m>=0) {
        	while(m>=0) {
        		nums1[t--] = nums1[m--];
        	}
        }
        else if(n >=0) {
        	while(n >= 0) {
        		nums1[t--] = nums2[n--];
        	}
        }
    }
}
