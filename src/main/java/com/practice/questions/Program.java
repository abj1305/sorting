package com.practice.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Program {
	
	public static void main(String args []) {
		List<Integer> jobs = List.of(1,2,3,4);
		List<Integer[]> deps = new ArrayList<Integer[]>();
		deps.add(new Integer[]{1,2});
		deps.add(new Integer[]{1,3});
		deps.add(new Integer[]{3,2});
		deps.add(new Integer[]{4,2});
		deps.add(new Integer[]{4,3});
		
		System.out.println(
				topologicalSort(jobs, deps)
				);
		
	}

	public static List<Integer> topologicalSort(
			List<Integer> jobs, List<Integer[]> deps
			) {

		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> [] graph = new ArrayList[jobs.size()]; 

		for(int i = 0; i < jobs.size();i++){
			graph[i] = new ArrayList<Integer>();  
		}

		for(Integer [] arr : deps) {
			graph[arr[0]-1].add(arr[1]-1);
		}
		
		

		boolean visited [] = new boolean[jobs.size()];
		for(int i = 0; i < jobs.size();i++){
			if(!visited[i]) {
				sort(i, visited, jobs, graph, stack);
			}
		}

		for(int j = 0 ;j<stack.size();j++) {
			list.add(stack.pop()+1);
		}
		while(!stack.isEmpty()) {
			list.add(stack.pop()+1);
		}

		return list;
	}

	public static void sort(int i, boolean []visited, List<Integer>jobs, 
			ArrayList<Integer> [] graph, Stack<Integer> stack) {
		visited[i] = true;
		for(Integer in : graph[i]) {
			if(! visited[in]) {
				sort(in, visited, jobs, graph, stack);
			}
		}

		stack.push(i);
	}
	
	public boolean isGraphCyclic(ArrayList<Integer> [] graph) {
		return true;
	}
}

class Program2 {

	public static void main(String[] args) {
		ArrayList<Integer> redShirtHeights =
				new ArrayList<Integer>(Arrays.asList(5, 8, 1, 3, 4, 9));
		ArrayList<Integer> blueShirtHeights =
				new ArrayList<Integer>(Arrays.asList(6, 9, 2, 4, 5, 1));
		System.out.println(classPhotos(redShirtHeights, blueShirtHeights));

	}

	public static int minimumWaitingTime(int[] queries) {
		Arrays.sort(queries);
		int sum = 0;
		for (int i = 0; i < queries.length - 1; i++) {
			sum = sum + (queries[i] * (queries.length - (i + 1)));
		}
		return sum;
	}

	public static boolean  classPhotos( ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
		Collections.sort(blueShirtHeights);
		Collections.sort(redShirtHeights);

		if(blueShirtHeights.get(0) < redShirtHeights.get(0)) {
			for(int i = 0; i<blueShirtHeights.size();i++) {
				if(blueShirtHeights.get(i) >= redShirtHeights.get(i)) {
					return false;
				}
			}
		}
		else{
			for(int i = 0; i<blueShirtHeights.size();i++) {
				if(redShirtHeights.get(i) >= blueShirtHeights.get(i)) {
					return false;
				}
			}
		}

		return true;
	}
}
