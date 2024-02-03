package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<Integer> sequentialDigits(int low, int high) {
    	List<Integer> ans = new ArrayList<Integer>();
    	String s = "123456789";
    	int n = 9;
    	for(int i = 0 ; i < n ; i++) {
    		for(int j = i+1; j <= n ; j++) {
    			Integer x = Integer.valueOf(s.substring(i, j));
    			if(x >= low && x <= high) {
    				ans.add(x);
    			}
    			if(x > high) break;
    		}
    	}
    	Collections.sort(ans);
    	return ans;
    }
}
