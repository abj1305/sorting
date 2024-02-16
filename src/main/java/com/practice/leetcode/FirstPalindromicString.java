package com.practice.leetcode;

public class FirstPalindromicString {

	public static void main(String args[]) {
		
	}
	
    public String firstPalindrome(String[] words) {
        for(String word : words) {
        	if(isPalindrome(word)) return word;
        }
        return "";
    }
    
    private boolean isPalindrome(String string) {
    	int l = 0;
    	int r = string.length()-1;
    	
    	while(l<r) {
    		if(string.charAt(l) == string.charAt(r)) {
    			l++;
    			r--;
    		}
    		else {
    			return false;
    		}
    	}
    	return true;
    }
	
}
