package com.practice.dsa.anuj.graph;

import java.util.ArrayList;
import java.util.Stack;

public class GraphTopologicalSortUsingDFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int v) {
		boolean visited [] = new boolean[v];
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i< v; i++) {
			if(!visited[i]) {
				topologicalSort(adj, v, visited, stack);
			}
		}
		
		int [] ans = new int [v];
		int index = 0;
		while(!stack.isEmpty()) {
			ans[index++] = stack.pop();
		}
	}
	
	public static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int v, 
			boolean [] visited, Stack<Integer> stack) {
		visited[v] = true;
		for(Integer neigh: adj.get(v)) {
			if(!visited[neigh]) {
				topologicalSort(adj, neigh, visited, stack);
			}
		}
		stack.push(v);
	}
	
}
