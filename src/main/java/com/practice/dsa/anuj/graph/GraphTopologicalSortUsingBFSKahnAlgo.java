package com.practice.dsa.anuj.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTopologicalSortUsingBFSKahnAlgo {

	public static void main(String args[]) {
		
	}
	
	/*
	 * To find topological sort using BFS
	 * Instead of visited array, add in queue IFF indegree is 0.
	 * 
	 * 
	 */
	public static void topologicalSortUsingBFSKahn(ArrayList<ArrayList<Integer>> adj, int V) {
		
		int [] inDeg = new int[V];
		
		for(ArrayList<Integer> list : adj) {
			for(Integer i : list) {
				inDeg[i] ++;
			}
		}
		
		boolean [] visited = new boolean[V]; // not required
		ArrayList<Integer> ansList = new ArrayList<Integer>();
		
		bfs(adj, V, visited, ansList, inDeg);
		
		System.out.println(ansList);
		
	}
	
	public static void bfs(ArrayList<ArrayList<Integer>> adj, int V, boolean [] visited,
			ArrayList<Integer> ansList, int [] inDeg) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=0;i<V;i++) {
			if(inDeg[i]==0) {
				q.add(i);
			}
		}
		
		while(! q.isEmpty()) {
			int cur = q.poll();
			ansList.add(cur);
			
			for(Integer neighbor : adj.get(cur)) {
				if(--inDeg[neighbor] == 0) {
					q.add(neighbor);
				}
			}
		}
		
		
		
	}
	
}
