package com.practice.dsa.anuj.graph;

import java.util.ArrayList;
import java.util.Collections;

class Edge implements Comparable<Edge> {

	int src, dest, wt;
	
	public Edge(int src, int dest, int wt) {
		this.src = src;
		this.dest = dest;
		this.wt = wt;
	}
	
	@Override
	public int compareTo(Edge that) {
		return this.wt-that.wt;
	}
	
}

public class GraphKruskalsAlgo {

	
	static int p[], rank[];
	
	static int find(int x) {
		if(x == p[x]) return x;
		return find(p[x]);
	}
	
	static void union(int x, int y) {
		int rx = find(x);
		int ry = find(y);
		if(rx==ry) return;
		p[ry] = rx;
	}
	
	//Function to find sum of weights of edges on the Minimum spanning tree
	static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
		
		boolean added [][] = new boolean[V][V];
		ArrayList<Edge> edges = new ArrayList<Edge>();
		
		for(int i=0;i<adj.size();i++) {
			for(int j=0;j<adj.get(i).size();j++) {
				ArrayList<Integer> cur = adj.get(i).get(j);
				if(!added[i][cur.get(0)]) {
					added[i][cur.get(0)] = true;
					added[cur.get(0)][i] = true;
					edges.add(new Edge(i, cur.get(0), cur.get(1)));
				}
			}
		}
		
		p = new int[V];
		for(int i=0;i<V;i++) {
			p[i] = i;
		}
		
		// main logic from here
		Collections.sort(edges);
		
		int count = 1;
		int ans = 0;
		
		for(int i=0;count<V;i++) {
			Edge edge = edges.get(i);
			int rx = find(edge.src);
			int ry = find(edge.dest);
			
			if(rx != ry) {
				union(rx,ry);
				count++;
				ans += edge.wt;
			}
		}
		
		return ans;
	}
	
}
