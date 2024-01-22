package com.practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UniqueOccurances {

	public static void main(String args []) {
		UniqueOccurances u = new UniqueOccurances();
		u.uniqueOccurrences(new int [] {1, 2, 2, 0, 0});
	}

	public boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i : arr) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			}
			else {
				map.put(i, 1);
			}
		}
		int [] array = new int [2001];
		Arrays.fill(array, 5000);
		for(int i : map.keySet()) {
			int index = map.get(i);
			if(array[index]!=5000) return false;
			array[index] = i;
		}
		return true;
	}

}
