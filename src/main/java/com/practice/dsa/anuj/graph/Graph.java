package com.practice.dsa.anuj.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Graph {

	
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		ArrayList<ArrayList<Integer>> adj = createAdjacencyList();
		System.out.println(adj);
		
		

	}
	
	public static ArrayList<ArrayList<Integer>> createAdjacencyList() {
		System.out.println("Enter number of Edges: ");
		int edges = sc.nextInt();
		System.out.println("Enter number of Vertices: ");
		int vertices = sc.nextInt();
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		adj.add(new ArrayList<Integer>());
		for (int i = 1 ; i<= vertices ; i++) {
			adj.add(new ArrayList<Integer>());
		}
		for(int i = 1;i<=edges;i++) {
			System.out.println("source - " + i);
			int source = sc.nextInt();
			System.out.println("dest - " + i);
			int dest = sc.nextInt();
			addEdge(adj, source, dest);
		}
		return adj;
	}
	
	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int source, int dest) {
		adj.get(source).add(dest);
		adj.get(dest).add(source);
	}
	
	private static boolean bfs (ArrayList<ArrayList<Integer>> adj, int src, 
			int dest, int v, int pred [], int dist []) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean visited [] = new boolean [v];
		for(int i = 0 ;i<v;i++) {
			visited[i] = false;
			dist[i] = Integer.MAX_VALUE;
			pred[i] = -1;
		}
		
		visited [src] = true;
		dist[src] = 0;
		q.add(src);
		
		while(! q.isEmpty()) {
			int cur = q.poll();
			for(Integer neighbour : adj.get(cur)) {
				if(! visited[neighbour]) {
					visited[neighbour] = true;
					dist[neighbour] = dist[cur] + 1;
					pred[neighbour] = cur;
					q.add(neighbour);
					
					if(neighbour == dest) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private static List<Integer> dfs(int v, ArrayList<ArrayList<Integer>> adj) {
		boolean [] visited = new boolean[v];
		List<Integer> list = new ArrayList<Integer>();
		//dfs(v, adj, visited, list);
		// for multiple components (disconnected) nodes:
		for(int i = 0; i<v;i++) {
			if(!visited[i]) {
				dfs(i,adj, visited, list);
			}
		}
		return list;
		
	}
	
	private static void dfs(int v, ArrayList<ArrayList<Integer>> adj, 
			boolean [] visited, List<Integer> list) {
		visited[v] = true;
		list.add(v);
		for(Integer n : adj.get(v)) {
			if(!visited[n]) {
				dfs(n, adj, visited, list);
			}
		}
		
	}

}
