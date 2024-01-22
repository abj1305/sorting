package com.practice.leetcode.top75;

public class String_MergeAlternateString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public String mergeAlternately(String word1, String word2) {
        StringBuffer sb = new StringBuffer();
        int c1 = 0;
        int c2 = 0;
        while(c1 < word1.length() && c2 < word2.length()) {
        	sb.append(word1.charAt(c1++));
        	sb.append(word2.charAt(c2++));
        }
        if(c1 == word1.length()) {
        	while(c2 < word2.length()) {
        		sb.append(word2.charAt(c2++));
        	}
        }
        if(c2 == word2.length()) {
        	while(c1 < word1.length()) {
        		sb.append(word1.charAt(c1++));
        	}
        }
        return sb.toString();
    }
}
