package com.practice.leetcode.top75;

public class Stack_RemoveStarFromString {
	
	public static void main(String args[]) {
		Stack_RemoveStarFromString r = new Stack_RemoveStarFromString();
		r.removeStars("leet**cod*e");
	}
	
    public String removeStars(String s) {
    	StringBuffer sb = new StringBuffer();
    	int index = 0;
    	for(char c : s.toCharArray()) {
    		if(c != '*') {
    			sb.append(c);
    			index++;
    		}
    		else {
    			sb.deleteCharAt(--index);
    		}
    	}
    	return sb.toString();
    }

}
