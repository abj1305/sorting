package com.practice.leetcode.top150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String args []) {

	}

	public List<List<String>> groupAnagrams(String[] strs) {
		if(strs == null || strs.length ==0) return new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for(String s : strs) {
			String key = getMapKey(s);
			if(map.containsKey(key)) {
				map.get(key).add(s);
			}
			else {
				List<String> list = new ArrayList<String>();
				list.add(s);
				map.put(key, list);
			}
		}
		return new ArrayList<List<String>>(map.values());
	}
	
	private String getMapKey(String str) {
		char [] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
	}
}
