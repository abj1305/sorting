package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar {

	public static void main(String[] args) {
		FirstUniqueChar f = new FirstUniqueChar();
		f.firstUniqChar("loveleetcode");

	}
	
    public int firstUniqChar(String s) {
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
    	for(char c : s.toCharArray()) {
    		if(map.containsKey(c)) {
    			map.put(c, map.get(c)+1);
    		}
    		else {
    			map.put(c, 1);
    		}
    	}
    	int index = 0;
    	for(char c : s.toCharArray()) {
    		if(map.get(c)==1) {
    			return index;
    		}
    		index ++;
    	}
    	return -1;
    }

}
