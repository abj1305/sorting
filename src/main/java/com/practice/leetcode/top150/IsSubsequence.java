package com.practice.leetcode.top150;

public class IsSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSubsequence(String s, String t) {
		if(s.length() == 0) return true;
		int sp = 0;
		for(char c : t.toCharArray()) {
			if(s.charAt(sp) == c) {
				sp++;
			}
			if(sp == s.length()) {
				return true;
			}
		}
		return sp == s.length();
	}
}
