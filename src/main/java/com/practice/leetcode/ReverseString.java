package com.practice.leetcode;

public class ReverseString {
	
	public static void main(String args []) {
		char [] s = new char [] {'h','e','l','l','o'};
		ReverseString r = new ReverseString();
		r.reverseString(s);
		System.out.println(s);
		
	}
	
    public void reverseString(char[] s) {
        int l = 0;
    	int r = s.length-1;
    	while(l < r) {
    		char c = s[l];
    		s[l++] = s[r];
    		s[r--] = c;
    	}
    }

}
