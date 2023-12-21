package com.practice.dsa.anuj.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class GraphDijkstrasAlgo {

	public static void main(String[] args) {

	}

	// Does NOT work with negative edges
	public static int [] findShortedPathArray(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
		boolean [] visited = new boolean[V];
		int [] ans = new int [V]; // has distance from source
		Arrays.fill(ans, Integer.MAX_VALUE);
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		
		// assuming source as 0
		q.add(new Pair(0, 0)); // 0 as source and 0 is its distance from itself
		ans[0] = 0;
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			int u = cur.v;
			if(visited[u]) {
				continue;
			}
			visited[u] = true;
			ArrayList<ArrayList<Integer>> neighbor = adj.get(u);
			for(ArrayList<Integer> list  :neighbor) {
				int vertex = list.get(0);
				int wt = list.get(1);
				if(ans[vertex] > ans[u] + wt) {
					ans[vertex] = ans[u] + wt;
					q.add(new Pair(vertex, ans[vertex]));
				}
			}
		}
		return ans;
		
	}
}
