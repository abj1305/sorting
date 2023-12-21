package com.practice.dsa.anuj.graph;

import java.util.ArrayList;

public class GraphCycleDirected {

	public static void main(String[] args) {

	}
	
	public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean visited [] = new boolean [V];
		boolean recS [] = new boolean [V];
		for(int i = 0;i<V;i++) {
			if(dfs(i, adj, visited, recS)) return true;
		}
		return false;
	}

	private static boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recS) {
		visited[v] = true;
		recS[v] = true;
		
		for(Integer n : adj.get(v)) {
			if(! visited[n]) {
				if(dfs(n, adj, visited, recS)) return true;
			}
			else if(recS[n]) {
				return true;
			}
		}
		recS[v] = false;
		return false;
	}

}
