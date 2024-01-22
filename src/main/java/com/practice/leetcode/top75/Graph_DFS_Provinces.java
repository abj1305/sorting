package com.practice.leetcode.top75;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Graph_DFS_Provinces {
	
	public static void main(String args[]) {
		int [][] matrix = {
				{1,1,0}, {1,1,0}, {0, 0,1}
		};
		Graph_DFS_Provinces p = new Graph_DFS_Provinces();
		int i = p.findCircleNum(matrix);
		System.out.println(i);
	}
    
	
	private List<List<Integer>> getAdjecencyList(int [][] matrix) {
		List<List<Integer>> adj = new ArrayList<List<Integer>>();
		for(int i = 0 ; i < matrix.length; i++) {
			adj.add(i, new ArrayList<Integer>());
			for(int j = 0; j < matrix[0].length ; j++) {
				if(matrix[i][j] == 1 && i!=j) {
					adj.get(i).add(j);
				}
			}
		}
		return adj;
	}
	
	public int findCircleNum(int[][] isConnected) {
        int count = 0;
        List<List<Integer>> adj = getAdjecencyList(isConnected);
        boolean [] visited = new boolean[adj.size()];
        for(int i = 0 ; i < adj.size(); i++) {
        	if(!visited[i]) {
        		count ++;
        		dfs(visited, adj, i);
        	}
        }
        return count;
        
    }
    
	private void dfs(boolean[] visited, List<List<Integer>> adj, int vertex) {
		visited[vertex] = true;
		for(int n : adj.get(vertex)) {
			if(! visited[n]) {
				dfs(visited, adj, n);
			}
		}
	}
	
}
