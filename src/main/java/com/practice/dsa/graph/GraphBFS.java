package com.practice.dsa.graph;

import java.util.LinkedList;

class MyGraph2 {
	
	private int noOfVertices;
	private LinkedList<Integer> [] adjList;
	
	
	MyGraph2(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adjList = new LinkedList[noOfVertices];
		for(int i = 0; i<noOfVertices;i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int v, int w) {
		adjList[v].add(w);
	}
	
	public void BFS(int vertex) {
		boolean visited [] = new boolean[noOfVertices];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		queue.add(vertex);
		visited[vertex] = true;
		
		while(!queue.isEmpty()) {
			vertex = queue.poll();
            System.out.print(vertex + " ");
			LinkedList<Integer> list = adjList[vertex];
			for(Integer child : list) {
				if(!visited[child]) {
					queue.add(child);
					visited[child] = true;
				}
			}
		}
	}
}



public class GraphBFS {

	public static void main(String args []) {
		MyGraph2 g = new MyGraph2(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		
		g.BFS(2);
	}
	
}