package com.practice.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GroupAnagram {

	public static void main(String args[]) {
		List<String> words = List.of("yo", "oy", "has", "ash");
		groupAnagrams(words);
	}
	
	public static List<List<String>> groupAnagrams(List<String> words) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for(String word : words) {
			String key = getKey(word);
			if(map.containsKey(key)) {
				map.get(key).add(word);
			}
			else {
				List<String> list = new ArrayList<String>();
				list.add(word);
				map.put(key, list);
			}
		}
		List<List<String>> ans = new ArrayList<List<String>>();
		for(Entry<String, List<String>> entry : map.entrySet()) {
			ans.add(entry.getValue());
		}
		return ans;
	}
	
	private static String getKey(String word) {
		char [] array = word.toCharArray();
		Arrays.sort(array);
		return String.valueOf(array);
	}

}
