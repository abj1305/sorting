package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TribonacciNo {

	public static void main(String[] args) {
		

	}
	
    public int tribonacci(int n) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        return tribonacci(n, map);
    }
    
    public int tribonacci(int n, Map<Integer, Integer> map) {
        if(n==0) return 0;
        if(n<3) return 1;
        if(map.containsKey(n)) {
        	return map.get(n);
        }
        int t = tribonacci(n-1, map) + tribonacci(n-2, map)+ tribonacci(n-3, map);
        map.put(n, t);
        return t;
    }
}
