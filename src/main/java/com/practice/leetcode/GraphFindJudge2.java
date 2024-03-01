package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GraphFindJudge2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findJudge(int n, int[][] trust) {
		int [] trustCount = new int[n+1];
		List<List<Integer>> adj = new ArrayList<List<Integer>>();
		
		for(int i=0;i <=n ;i++) {
			adj.add(i, new ArrayList<Integer>());
		}
		
		for(int [] arr : trust) {
			adj.get(arr[1]).add(arr[0]);
			trustCount[arr[0]] ++;
		}
		
		for(int i=1; i < adj.size(); i++) {
			if(adj.get(i).size() == n-1 && trustCount[i] == 0) {
				return i;
			}
		}
		
		
		return -1;
		
	}

}
