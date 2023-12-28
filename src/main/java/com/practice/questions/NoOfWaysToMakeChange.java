package com.practice.questions;

public class NoOfWaysToMakeChange {

	public static void main(String args []) {
		int n = numberOfWaysToMakeChange(6, new int []{1,5});
		System.out.println(n);
	}


	public static int numberOfWaysToMakeChange(int n, int[] denoms) {
		 //return helper(n, denoms, 0);
		int ways []  = new int [n+1];
		ways[0] = 1;
		for(int denom : denoms) {
			for(int amount = 1; amount <n+1;amount ++) {
				if(denom <= amount) {
					ways[amount] = ways[amount] + ways[amount-denom];
				}
			}
		}
		return ways[n];
	}
	
//	public static int numberOfWaysToMakeChange(int n, int[] denoms) {
//		 return helper(n, denoms, 0);
//	}
	
	public static int helper(int n, int [] demons, int currentCoin) {
		if(n<0) return 0;
		if (n ==0) return 1;
		int ways = 0;
		for(int i = currentCoin;i<demons.length;i++) {
			ways += helper(n-demons[i], demons, i);
		}
		return ways;
	}
	
}
