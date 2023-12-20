package com.practice.dsa.anuj.graph;

import java.util.ArrayList;

public class GraphUndirectedCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		
		boolean [] visited = new boolean[V];
		for(int i = 0; i<V;i++) {
			if(dfs(i, adj, visited, -1)) return true;
		}
		return false;
	}

	private static boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent) {
		visited[v] = true;
		for(Integer neighbour : adj.get(v)) {
			if(!visited[neighbour]) {
				if(dfs(neighbour, adj, visited, v)) return true;
			}
			else if(neighbour != parent) return true;
		}
		return false;
		
	}

}
