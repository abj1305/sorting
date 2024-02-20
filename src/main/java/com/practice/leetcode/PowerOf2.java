package com.practice.leetcode;

public class PowerOf2 {
	
	public static void main (String args[]) {
		PowerOf2 p = new PowerOf2();
		p.isPowerOfTwo(32);
	}
	
    public boolean isPowerOfTwo(int n) {
    	if(n<1) return true;
    	return (n & (n-1)) == 0;
    }

}
