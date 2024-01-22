package com.practice.leetcode.top75;

import java.util.List;

public class Graph_DFS_KeysAndRooms {
	
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] visited = new boolean[rooms.size()];
        dfs(rooms, visited, 0);
        for(boolean b : visited) {
        	if(!b) return false;
        }
        return true;
    }
    
    private void dfs(List<List<Integer>> adj, boolean[]visited, int vertex) {
    	visited[vertex] = true;
    	for(int n : adj.get(vertex)) {
    		if(!visited[n]) {
    			dfs(adj, visited, n);
    		}
    	}
    }

}
