package com.practice.leetcode;

import java.util.Arrays;

public class FindMinRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int findMin(int[] nums) {
        return Arrays.stream(nums).min().getAsInt();
    }

}
