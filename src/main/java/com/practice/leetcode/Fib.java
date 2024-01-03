package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/fibonacci-number/description/
public class Fib {

	public static void main(String[] args) {
		

	}
	
    public int fib(int n) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	return fib(n, map);
    }
    
    public int fib(int n, Map<Integer, Integer> map) {
    	if(n == 0) return 0;
    	if(n == 1) return 1;

    	if(map.containsKey(n)) {
    		return map.get(n);
    	}
    	else {
    		int f = fib(n-1, map) + fib(n-2, map);
    		map.put(n, f);
    		return f;
    	}
    }
}
