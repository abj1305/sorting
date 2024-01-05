package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GraphCourseSchedule2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    	boolean visited [] = new boolean[numCourses];
    	boolean recS [] = new boolean[numCourses];
    	List<List<Integer>> adjList = new ArrayList<List<Integer>>();
    	for(int i = 0;i<numCourses;i++) {
    		adjList.add(i,new ArrayList<Integer>());
    	}
    	for(int [] edge : prerequisites) {
    		adjList.get(edge[1]).add(edge[0]);
    	}
    
    	for(int i = 0 ; i < numCourses ; i++) {
    		if(! visited[i]) {
    			if(isCyclic(adjList, i, visited, recS)) {
    				return new int [0];
    			}
    		}
    	}
    	Stack<Integer> stack = new Stack<Integer>();
    	Arrays.fill(visited, false);
    	for(int i = 0 ; i<numCourses; i++) {
    		if(!visited[i]) {
    			topologicalSort(adjList, i, visited, stack);
    		}
    	}
    	int [] ans = new int [stack.size()];
    	int i = 0;
    	while(!stack.isEmpty()) {
    		ans[i++] = stack.pop();
    	}
    	
    	return ans;
    	
    }
    
    private boolean isCyclic(List<List<Integer>> adjList, int vertex, boolean[] visited, boolean [] recS) {
    	visited[vertex] = true;
    	recS[vertex] = true;
    	for(int neighbor : adjList.get(vertex)) {
    		if(!visited[neighbor]) {
    			if(isCyclic(adjList, neighbor, visited, recS)) {
    				return true;
    			}
    		}
    		else if(recS[neighbor]) {
        		return true;
        	}
    	}
    	recS[vertex] = false;
    	return false;
    }
    
    private void topologicalSort(List<List<Integer>> adjList, int vertex, boolean[] visited, Stack<Integer> stack) {
    	visited[vertex] = true;
    	for(int neighbor : adjList.get(vertex)) {
    		if(!visited[neighbor]) {
    			topologicalSort(adjList, neighbor, visited, stack);
    		}
    	}
    	stack.push(vertex);
    }

}
