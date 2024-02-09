package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencySort {
	
	public static void main(String args []) {
		FrequencySort f = new FrequencySort();
		f.frequencySort("tttrrrrrreeeeeeeeeeee");
	}
	
	class Pair{
		int count;
		char c;
		public Pair(char c, int count) {
			this.c = c;
			this.count = count;
		}
	}
	
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) {
        	if(map.containsKey(c)) {
        		map.put(c, map.get(c) + 1);
        	}
        	else {
        		map.put(c, 1);
        	}
        }
        List<Pair> list = new ArrayList<Pair>();
        
        for(char c : map.keySet()) {
        	Pair p = new Pair(c, map.get(c));
        	list.add(p);
        }
        
        Collections.sort(list, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return o2.count - o1.count;
			}
		});
        
        StringBuffer sb = new StringBuffer();
        for(Pair p : list) {
        	for(int i = 0 ; i < p.count; i++) {
        		sb.append(String.valueOf(p.c));
        	}
        }
        return sb.toString();
    }

}
