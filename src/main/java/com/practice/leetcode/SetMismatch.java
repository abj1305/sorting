package com.practice.leetcode;

public class SetMismatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int[] findErrorNums(int[] nums) {
        int counter [] = new int[10001];
        for(int num : nums) {
        	counter[num] ++;
        }
        int ans[] = new int[2];
        for(int i = 1 ; i <= nums.length; i++) {
        	if(counter[i] == 0) ans[1] = i;
        	else if(counter[i]==2) ans[0] = i;
        }
        return ans;
    }
}
