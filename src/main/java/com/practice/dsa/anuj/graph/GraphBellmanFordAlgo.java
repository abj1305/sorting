package com.practice.dsa.anuj.graph;

import java.util.Arrays;

//this works with negative edges too.
public class GraphBellmanFordAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int isNegative(int n, int [][] edges) {
		int dist [] = new int [n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;

		for(int count=0;count<n;count++) {
			for(int i=0;i<edges.length;i++) {
				int src = edges[i][0];
				int dest = edges[i][1];
				int wt = edges[i][2];
				if(dist[src] != Integer.MAX_VALUE && 
						dist[dest] > dist[src] + wt ) {
					dist[dest] = dist[src]+wt;
				}
			}
		}
		 
		// Iterating nth time to check the cycle
		for(int i=0;i<edges.length;i++) {
			int src = edges[i][0];
			int dest = edges[i][1];
			int wt = edges[i][2];
			if(dist[src] != Integer.MAX_VALUE && 
					dist[dest] > dist[src] + wt ) {
				return 1;
			}
		}
		return 0;
	}



}
