package com.practice.leetcode;

import java.util.List;

public class MaxLengthConcatenatedString {

	public static void main(String[] args) {
		
		MaxLengthConcatenatedString m = new MaxLengthConcatenatedString();
		m.maxLength(List.of("cha","r","act","ers"));

	}
	
	int max = 0;
    public int maxLength(List<String> arr) {
        rec(arr, 0, "");
        return max;
    }
    private void rec (List<String> arr, int idx, String cur) {
        if (idx == arr.size()){
            if(cur.length() > max && uniqueCharacters(cur)) {
                max = cur.length();
            }
            return;
        }
        rec(arr, idx + 1, cur);
        rec(arr, idx + 1, cur + arr.get(idx));
    }
    private boolean uniqueCharacters(String cur) {
        int[] res = new int[26];
        for (char c : cur.toCharArray()) {
            if (res[c - 'a'] > 0) {
                return false;
            }
            res[c - 'a']++;
        }
        return true;
    }

}
