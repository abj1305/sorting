package com.practice.dsa.dp;

import java.util.Arrays;

public class NthFibonacci {

	public static void main(String args []) {
		System.out.println(nthFibonacci(5));
	}

	static int nthFibonacci(int n){
		int [] arr = new int [n+1];
		Arrays.fill(arr, -1);
		int f = nthFibonacci(n, arr);
		return f;
    }

	static int nthFibonacci(int n, int [] arr){
		if(n < 3) return 1;
		if(arr[n] != -1) {
			return arr[n];
		}
		int f= (nthFibonacci(n-1, arr) + nthFibonacci(n-2, arr)) % 1000000007;
		arr[n] = f;
		return f;
	}
}
