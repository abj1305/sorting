package com.practice.questions;

import java.util.Arrays;

public class NonConstructibleChange {

	public static void main(String args []) {

		NonConstructibleChange obj = new NonConstructibleChange();
		int nonConstructibleChange = obj.nonConstructibleChange(new int[] {1,1,4});
		System.out.println(nonConstructibleChange);
		
	}

	public int nonConstructibleChange(int[] coins) {
		Arrays.sort(coins);
		int change = 0;
		for(int coin : coins) {
			if(coin > change+1) {
				return change+1;
			}
			change += coin;
		}
		return change+1;
	}
}
