package com.practice.leetcode.top150;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : nums) {
        	if(map.containsKey(i)) {
        		map.put(i, map.get(i)+1);
        	}
        	else {
        		map.put(i, 1);
        	}
        	
        	if(map.get(i) > nums.length/2) {
        		return i;
        	}
        }
        return 0;
    }

}
