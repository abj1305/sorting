package com.practice.dsa.graph;

import java.util.LinkedList;

class MyGraph {
	
	private int noOfVertices;
	private LinkedList<Integer> [] adjList;
	
	
	MyGraph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adjList = new LinkedList[noOfVertices];
		for(int i = 0; i<noOfVertices;i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int v, int w) {
		adjList[v].add(w);
	}
	
	public void DFS(int vertex) {
		boolean [] visited = new boolean[noOfVertices];
		dfsRecursive(vertex, visited);
		
	}
	
	public void dfsRecursive(int vertex, boolean [] visited) {
		visited[vertex] = true;
		System.out.print(vertex + " ");
		for(Integer child : adjList[vertex]) {
			if(! visited[child]) {
				dfsRecursive(child, visited);
			}
		}
	}
}



public class GraphDFS {

	public static void main(String args []) {
		MyGraph g = new MyGraph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		
		g.DFS(2);
	}
	
}