package com.practice.dsa.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class FindCycle {
	
	private int V;

	private LinkedList<Integer> adj[];
	
	public FindCycle(int v) {
		V = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int a, int b) {
		adj[a].add(b);
	}

	

	public static void main(String args[])
	{
		FindCycle g = new FindCycle(6);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		
		
		System.out.println(
				g.isGraphCyclic()
				);
		
	}
	
	public boolean isGraphCyclic() {
		
		boolean [] visited = new boolean[V];
		Set<Integer> ancestors = new HashSet<Integer>();
		
		return isCyclic(0, visited, ancestors);
		
	}
	
	public boolean isCyclic(Integer vertex, boolean [] visited, Set<Integer> ancestors) {
		boolean flag = false;
		visited[vertex] = true;
		if(ancestors.contains(vertex)) {
			return true;
		}
		ancestors.add(vertex);
		for(Integer child: adj[vertex]) {
			
			//if(!visited[child]) {
				flag = isCyclic(child, visited, ancestors);
				if(flag) return true;
			//}
		}
		ancestors.remove(vertex);
		return false;
		
	}

}
