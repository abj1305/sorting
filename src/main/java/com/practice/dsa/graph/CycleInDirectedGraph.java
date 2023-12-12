package com.practice.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CycleInDirectedGraph {

	public static void main(String[] args) {
		
		CycleInDirectedGraph q = new CycleInDirectedGraph();
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		adj.add(new ArrayList(Arrays.asList(1)));
		adj.add(new ArrayList(Arrays.asList(2,4)));
		adj.add(new ArrayList(Arrays.asList(3)));
		adj.add(new ArrayList(Arrays.asList(4)));
		adj.add(new ArrayList(Arrays.asList(1)));
		
		System.out.println(
				q.isCyclic(5, adj)
				);

	}
	
	//https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1?page=1&difficulty=Medium&sortBy=submissions
	public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean [] visited = new boolean[V];
        Set<Integer> ancestors = new HashSet<Integer>();
        
        for(int i=0;i<V;i++) {
        	if(! visited[i]) {
        		if(isCyclic(i, visited, adj, ancestors)) {
        			return true;
        		}
        	}
        }
		
		return false;
    }
    
    public boolean isCyclic(Integer vertex, boolean [] visited, ArrayList<ArrayList<Integer>> adj, Set<Integer> ancestors) {
    	visited[vertex] = true;
    	
    	if(ancestors.contains(vertex)) {
    		return true;
    	}
    	
    	ancestors.add(vertex);
    	
    	for(Integer child : adj.get(vertex)) {
    		if(! visited[child]) {
    			if(isCyclic(child, visited, adj, ancestors)) {
    				return true;
    			}
    		}
    		else if(ancestors.contains(child)) {
    			return true;
    		}
    	}
    	ancestors.remove(vertex);
    	return false;
    }

}
