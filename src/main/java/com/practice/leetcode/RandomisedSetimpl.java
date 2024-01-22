package com.practice.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class RandomizedSet {
	
	Map <Integer, Integer> map = null;
	Integer dummy = 0;
	
	public RandomizedSet() {
		map = new HashMap<Integer, Integer>();
	}

	public boolean insert(int val) {
		boolean b = map.containsKey(val);
		if(b) {
			return false;
		}
		else {
			map.put(val, dummy);
			return true;
		}
	}

	public boolean remove(int val) {
		boolean b = map.containsKey(val);
		if(b) {
			map.remove(val);
			return true;
		}
		else {
			return false;
		}
		
	}

	public int getRandom() {
		List<Integer> list = map.entrySet().stream().map(p -> p.getKey()).collect(Collectors.toList());
		int random = (int)(Math.random() * list.size());
		return list.get(random);
	}
}

public class RandomisedSetimpl {
	public static void main(String args []) {

//		RandomizedSet obj = new RandomizedSet();
//		boolean param_1 = obj.insert(val);
//		boolean param_2 = obj.remove(val);
//		int param_3 = obj.getRandom();

	}
}
