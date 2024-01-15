package com.practice.leetcode;

public class AnagramMinSteps {
	
	public static void main(String args []) {
		
	}
	
    public int minSteps(String s, String t) {
    	int count=0;
    	int [] arr = new int [26];
    	for(int i = 0 ;i < s.length();i++) {
    		arr[s.charAt(i) - 'a'] ++;
    		arr[t.charAt(i) - 'a'] --;
    	}
    	for(int i : arr) {
    		if(i != 0) {
    			count += Math.abs(i);
    		}
    	}
    	return count/2;
    }

}
