package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GraphValidPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean validPath(int n, int[][] edges, int source, int destination) {
    	List<List<Integer>> graph = getGraph(n, edges);
        return dfs(n, graph, source, destination);
    }
    
    public boolean dfs(int n, List<List<Integer>> graph, int src, int dest) {
    	boolean [] visited = new boolean[n];
    	boolean b = dfsUtil(graph, src, dest, visited);
    	return b;
    }
    
    public boolean dfsUtil(List<List<Integer>> graph, int src, int dest, boolean[]visited) {
    	visited[src] = true;
    	if(src == dest) return true;
    	
    	for(int neighbor : graph.get(src)) {
    		if(!visited[neighbor]) {
    			if(dfsUtil(graph, neighbor, dest, visited)) {
    				return true;
    			}
    		}
    	}
    	
    	return false;
    }
    
    public List<List<Integer>> getGraph(int n, int[][] edges) {
    	List<List<Integer>> graph = new ArrayList<List<Integer>>();
    	for(int i = 0 ;i<=n;i++) {
    		graph.add(i, new ArrayList<Integer>());
    	}
    	for(int [] edge : edges) {
    		graph.get(edge[0]).add(edge[1]);
    		graph.get(edge[1]).add(edge[0]);
    	}
    	
    	return graph;
    }

}
