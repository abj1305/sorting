package com.practice.leetcode.top150;

public class NeedleInTheHaystack {

	public static void main(String[] args) {
		NeedleInTheHaystack n = new NeedleInTheHaystack();
		int i = n.strStr("a", "a");
	}
	
    public int strStr(String haystack, String needle) {
        for(int i = 0 ; i < (haystack.length()-needle.length()+1) ; i++ ) {
        	if(haystack.substring(i, i+needle.length()).equals(needle)) {
        		return i;
        	}
        }
        return -1;
    }

}
