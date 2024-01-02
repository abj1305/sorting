package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

	public static void main(String[] args) {

		ClimbingStairs c = new ClimbingStairs();
		int n = c.climbStairs(4);
		System.out.println(n);
	}

	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public int climbStairs(int n) {
		if(n<=1) return 1;
		if(map.containsKey(n)) {
			return map.get(n);
		}
		int v = climbStairs(n-1) + climbStairs(n-2);
		map.put(n, v);
		return v;
	}

}
