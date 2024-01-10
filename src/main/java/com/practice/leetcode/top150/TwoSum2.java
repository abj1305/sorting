package com.practice.leetcode.top150;

public class TwoSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] twoSum(int[] numbers, int target) {
		int l = 0;
		int r = numbers.length - 1;
		while(l < r) {
			if(numbers[l] + numbers[r] == target) {
				return new int [] {l+1, r+1};
			}
			else if(numbers[l] + numbers[r] < target) {
				l ++;
			}
			else {
				r--;
			}
		}
		return new int [] {-1, -1};
	}

}
