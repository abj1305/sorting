package com.practice.leetcode.top75;

import java.util.ArrayList;
import java.util.List;

public class String_ExtraCandies {
	
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    	int max = 0;
    	for(int i : candies) {
    		if(i > max) max = i;
    	}
    	List<Boolean> ans = new ArrayList<Boolean>();
    	for(int i : candies) {
    		if(i+extraCandies >= max) {
    			ans.add(true);
    		}
    		else {
    			ans.add(false);
    		}
    	}
    	return ans;
    }

}
