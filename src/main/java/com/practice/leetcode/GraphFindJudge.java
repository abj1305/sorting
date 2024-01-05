package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GraphFindJudge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findJudge(int n, int[][] trust) {

		List<List<Integer>> adjList = new ArrayList<List<Integer>>();
		adjList.add(0, new ArrayList<Integer>());
		int [] trustCount = new int[n+1];
		
		for(int i = 1; i<=n; i++) {
			adjList.add(i, new ArrayList<Integer>());
		}
		
		for(int [] edge : trust) {
			adjList.get(edge[1]).add(edge[0]);
			trustCount[edge[0]] ++;
		}
		
		for(int i = 1; i <= n ;i++) {
			if(adjList.get(i).size() == n-1 && trustCount[i] == 0) {
				return i;
			}
		}
		return -1;
		
	}

}
