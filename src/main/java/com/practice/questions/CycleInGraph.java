package com.practice.questions;

public class CycleInGraph {

	public static void main(String[] args) {
		int [][] edges = {
				{1},
				{2,3,4,5,6,7},
				{},
				{2,7},
				{5},
				{},
				{4},
				{}
		};
		CycleInGraph c = new CycleInGraph();
		boolean b = c.cycleInGraph(edges);
		System.out.println(b);
	}

	public boolean cycleInGraph(int[][] edges) {
		
		boolean visited [] = new boolean [edges.length];
		boolean recS [] = new boolean [edges.length];
		for(int i = 0 ;i<edges.length;i++) {
			for(int j = 0; j< edges[i].length ; j++) {
				if(! visited[edges[i][j]]) {
					if(isCyclic(i, edges, visited, recS)) return true;
				}
			}
		}
		return false;
	}

	public boolean isCyclic(int vertex , int [][] edges, boolean [] visited , boolean [] recS) {
		visited[vertex] = true;
		recS[vertex] = true;
		for(int nieghbor : edges[vertex]) {
			if(! visited[nieghbor]) {
				 if(isCyclic(nieghbor, edges, visited, recS)) return true;
			}
			else if(recS[nieghbor]) {
				return true;
			}
		}
		recS[vertex] = false;
		return false;
	}
	
}
