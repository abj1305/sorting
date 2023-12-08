package com.practice.dsa.graph;

import java.util.LinkedList;
import java.util.Stack;

public class MyGraphTopologicalSort {
	
	private int V;

	private LinkedList<Integer> adj[];
	
	public MyGraphTopologicalSort(int v) {
		V = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int a, int b) {
		adj[a].add(b);
	}

	

	// Driver code
	public static void main(String args[])
	{
		// Create a graph given in the above diagram
		MyGraphTopologicalSort g = new MyGraphTopologicalSort(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		System.out.println("Following is a Topological "
				+ "sort of the given graph");
		// Function Call
		g.topologicalSort();
	}

	private void topologicalSort() {
		
		boolean [] visited = new boolean[V];
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0 ; i< V; i++) {
			if(! visited[i])
				sort(i, stack, visited);
		}
		
		while(! stack.empty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	private void sort(int i, Stack<Integer> stack, boolean[] visited) {
		
		visited[i] = true;
		for(Integer neighbour : adj[i]) {
			if(! visited[i]) {
				sort(i, stack, visited);
			}
		}
		stack.push(i);
	}

}
