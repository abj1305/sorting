package com.practice.dsa.anuj.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;


class Pair implements Comparable<Pair> {

	int v;
	int wt;
	
	public Pair(int v, int wt) {
		this.v = v;
		this.wt = wt;
	}
	
	@Override
	public int compareTo(Pair that) {
		return this.wt - that.wt;
	}
	
}

// Minimum spanning tree
public class GraphPrimsAlgo {

	public static void main(String[] args) {

	}
	
	public static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj)  {
		boolean [] visited = new boolean[V];
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		
		q.add(new Pair(0,0));
		int ans = 0;
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			int u = cur.v;
			if(visited[u]) {
				continue;
			}
			ans = ans + cur.wt;
			visited[u] = true;
			ArrayList<ArrayList<Integer>> neighbor = adj.get(u);
			for(ArrayList<Integer> list: neighbor) {
				int vertex = list.get(0);
				int wt = list.get(1);
				if(!visited[vertex]) {
					q.add(new Pair(vertex, wt));
				}
			}
		}
		return ans;
	}

}
