package com.practice.leetcode;

public class AlikeHalves {
	
	public static void main(String args[]) {
		AlikeHalves a = new AlikeHalves();
		boolean b = a.halvesAreAlike("Book");
		System.out.println(b);
	}
	
    public boolean halvesAreAlike(String s) {
        int count = 0;
        for(int i = 0; i < s.length()/2;i++) {
        	if(isVowel(s.charAt(i))) count++;
        	if(isVowel(s.charAt(s.length()/2 + i))) count --;
        }
        return count==0;
    }
    
    private boolean isVowel(char c) {
    	return "AEIOUaeiou".indexOf(c) != -1;
    }

}
