package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/?envType=daily-question&envId=2024-01-04
public class MinOperations {

	public static void main(String[] args) {
		MinOperations m = new MinOperations();
		int i = m.minOperations(new int [] {2,3,3,2,2,4,2,3,4});
		System.out.println(i);

	}
	public int minOperations(int[] nums) {
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		for(int i : nums) {
			if(countMap.containsKey(i)) {
				countMap.put(i, countMap.get(i)+1);
			}
			else {
				countMap.put(i, 1);
			}
		}
		
		if(countMap.values().contains(1)) {
			return -1;
		}
		
		int ans=0;
		int tmp=0;
		for(int k : countMap.keySet()) {
			tmp = countMap.get(k);
			if(tmp%3 == 0) {
				ans = ans+(tmp/3);
			}
			else if(tmp%3 == 2) {
				ans = ans + (tmp/3) + 1;
			}
			else if(tmp%3 == 1) {
				tmp = tmp-4;
				ans = ans + (tmp/3) + 2;
			}
		}
		return ans;
	}

}
