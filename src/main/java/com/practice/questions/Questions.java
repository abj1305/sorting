package com.practice.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Questions {

	public static void main(String args []) {

		Set<Integer> set = new HashSet<Integer>();
		
		
		
		
	}

	public String[] commonCharacters(String[] strings) {
		
		String [] stringsWithUniqueChars = new String[strings.length];
		for(int i = 0;i<strings.length;i++) {
			stringsWithUniqueChars[i] = getUniqueCharString(strings[i]);
		}
	    
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		
		for(String str : stringsWithUniqueChars) {
			for(int i = 0; i < str.length();i++) {
				if(charMap.containsKey(str.charAt(i))) {
					charMap.put(str.charAt(i), charMap.get(str.charAt(i))+1);
				}
				else {
					charMap.put(str.charAt(i),1);
				}
			}
		}
		
		List<String> returnList = new ArrayList<String>();
		for(Character key : charMap.keySet()) {
			if(charMap.get(key) == strings.length) {
				returnList.add(String.valueOf(key));
			}
		}
		
	    return returnList.toArray(new String[returnList.size()]);
	}
	
	private String getUniqueCharString(String str) {
		Set<Character> set = new HashSet<Character>();
		for(int i = 0 ;i<str.length();i++) {
			set.add(str.charAt(i));
		}
		StringBuilder sb = new StringBuilder("");
		for(Character character : set) {
			sb.append(character);
		}
		
		return sb.toString();
	}
	
}
