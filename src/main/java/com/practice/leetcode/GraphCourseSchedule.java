package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GraphCourseSchedule {

	public static void main(String[] args) {
		GraphCourseSchedule c = new GraphCourseSchedule();
		int [][] arr = new int [2][2];
		arr[0][0] = 1;
		arr[0][1] = 0;
		arr[1][0] = 0;
		arr[1][1] = 1;
		c.canFinish(2, arr);

	}
	
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
    				return false;
    			}
    		}
    	}
    	return true;
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

}
