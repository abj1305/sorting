package com.practice.leetcode;

public class RotateString {

	public static void main(String[] args) {
		RotateString r = new RotateString();
		r.rotateString("bbbacddceeb", "ceebbbbacdd");

	}
	
    public boolean rotateString(String s, String goal) {
    	if(s.length() != goal.length()) return false;
    	char c = s.charAt(0);
    	int diffIndex = goal.indexOf(c);
    	for(int j = 0 ; j < s.length(); j++) {
    		boolean skip = false;
    		if(c == goal.charAt(j)) {
    			diffIndex = j;
    		}
    		else
    		{
    			continue;
    		}
        	int n = s.length();
        	for(int i = 1 ; i < s.length() && !skip; i++) {
        		if( s.charAt(i) != goal.charAt((i+diffIndex)%n)) skip = true;
        	}
        	if(! skip) return true;
    	}
    	return false;
    	
    }

}
