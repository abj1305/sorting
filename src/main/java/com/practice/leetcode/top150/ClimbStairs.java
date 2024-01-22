package com.practice.leetcode.top150;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	public int climbStairs(int n) {
		if(n == 1) return 1;
		if(n == 2) return 2;
		if(map.containsKey(n)) {
			return map.get(n);
		}
		int v = climbStairs(n-1) + climbStairs(n-2);
		map.put(n, v);
		return v;

	}

}
