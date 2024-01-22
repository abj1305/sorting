package com.practice.leetcode.top75;

public class DP_Tribonacci {
	
	public static void main(String args []) {
		DP_Tribonacci t = new DP_Tribonacci();
		int i = t.tribonacci(3);
	}

	public int tribonacci(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(n == 2) return 1;
		int minus1 = 1;
		int minus2 = 1;
		int minus3 = 0;
		int ans=0;
		for(int i=3; i<=n;i++) {
			ans = minus1 + minus2 + minus3;
			minus3 = minus2;
			minus2 = minus1;
			minus1 = ans;
		}
		return ans;
	}

}
