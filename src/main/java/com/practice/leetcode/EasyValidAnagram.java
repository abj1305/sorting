package com.practice.leetcode;

import java.util.Arrays;

public class EasyValidAnagram {

	public static void main(String args[]) {
		EasyValidAnagram e = new EasyValidAnagram();
		System.out.println(
				e.isAnagram("anagram", "nagaram")
				);
		
	}


	public boolean isAnagram2(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		
		Arrays.sort(sc);
		Arrays.sort(tc);
		
		return Arrays.equals(sc, tc);
		
	}
	
	public boolean isAnagram(String s, String t) {
		int arr [] = new int [26];
		for(char c : s.toCharArray()) 
			arr[c-'a'] ++;
		for(char c : t.toCharArray()) 
			arr[c-'a'] --;
		for(int i : arr) {
			if(i!=0) {
				return false;
			}
		}
		return true;
	}

}
