package com.practice.leetcode.top150;

public class IsAnagram {

	public static void main(String[] args) {
		
		IsAnagram i = new IsAnagram();
		i.isAnagram("abhijeet", "abhijete");
		

	}


	public boolean isAnagram(String s, String t) {
		int [] arr = new int [26];
		if(s.length() != t.length()) {
			return false;
		}
		for(int i = 0; i < s.length() ; i++ ) {
			arr[s.charAt(i) - 'a'] = arr[s.charAt(i) - 'a'] + 1;
			arr[t.charAt(i) - 'a'] = arr[t.charAt(i) - 'a'] - 1;
		}
		for(int i : arr) {
			if(i!=0) return false;
		}
		return true;
	}

	public boolean isAnagram2(String s, String t) {
		int [] arr = new int [26];
		for(char c : s.toCharArray()) {
			arr[c-'a'] ++;
		}
		for(char c : t.toCharArray()) {
			arr[c-'a'] --;
		}
		for(int i : arr) {
			if(i!=0) return false;
		}
		return true;
	}

}
