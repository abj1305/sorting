package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class GraphFindCenter {

	public static void main(String[] args) {
		

	}
	
//    public int findCenter(int[][] edges) {
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for(int [] edge : edges) {
//        	if(map.containsKey(edge[0])) {
//        		map.put(edge[0], map.get(edge[0])+1);
//        	}
//        	else {
//        		map.put(edge[0], 1);
//        	}
//        	
//        	if(map.containsKey(edge[1])) {
//        		map.put(edge[1], map.get(edge[1])+1);
//        	}
//        	else {
//        		map.put(edge[1], 1);
//        	}
//        }
//        
//        int noOfNodes = map.size();
//        
//        for(int key : map.keySet()) {
//        	if(map.get(key) == noOfNodes-1) {
//        		return key;
//        	}
//        }
//        return 0;
//    }
	
    public int findCenter(int[][] edges) {
        return (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) ? edges[0][0] : edges[0][1];
    }

}
