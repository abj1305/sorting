package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumFrequencies {

	public static void main(String[] args) {
		MaximumFrequencies f = new MaximumFrequencies();
		f.maxFrequencyElements(new int [] {1,2,2,3,1,4});

	}
	
    public int maxFrequencyElements(int[] nums) {
     Map<Integer, Integer> map = new HashMap<Integer, Integer>();
     int max = 0;
     for(int i : nums) {
    	 if(map.containsKey(i)) {
    		 map.put(i, map.get(i)+1);
    	 }
    	 else {
    		 map.put(i, 1);
    		 
    	 }
    	 if(map.get(i)>max) {
			 max = map.get(i);
		 }
     }
     
     int ans = 0;
     for(int key : map.keySet()) {
    	 if(map.get(key) == max) {
    		 ans = ans + max;
    	 }
     }
     return ans;
     
    }

}
