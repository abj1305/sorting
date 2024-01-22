package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindWinners {

	public List<List<Integer>> findWinners(int[][] matches) {

		Map<Integer, Integer> lossesMap = new HashMap<Integer, Integer>();
		
		for(int arr [] : matches) {
			if(! lossesMap.containsKey(arr[0])) {
				lossesMap.put(arr[0], 0);
			}
			if(! lossesMap.containsKey(arr[1])) {
				lossesMap.put(arr[1], 1);
			}
			else {
				lossesMap.put(arr[1],lossesMap.get(arr[1])+1);
			}
		}
		List<Integer> loss0 = new ArrayList<Integer>();
		List<Integer> loss1 = new ArrayList<Integer>();
		
		for(int key : lossesMap.keySet()) {
			if(lossesMap.get(key) == 0) {
				loss0.add(key);
			}
			else if(lossesMap.get(key) == 1) {
				loss1.add(key);
			}
		}
		
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Collections.sort(loss0);
		Collections.sort(loss1);
		ans.add(loss0);
		ans.add(loss1);
		return ans;
	}

}
