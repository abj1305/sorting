package com.practice.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

//import com.practice.dsa.anuj.bst.Node;

class Program3 {

	public static void main(String args []) {
		List<Integer> jobs = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
		List<Integer[]> deps = new ArrayList<Integer[]>();
		deps.add(new Integer[]{1, 2});
		deps.add(new Integer[]{1, 3});
		deps.add(new Integer[]{1, 4});
		deps.add(new Integer[]{1, 5});
		deps.add(new Integer[]{1, 6});
		deps.add(new Integer[]{1, 7});
		deps.add(new Integer[]{2, 8});
		deps.add(new Integer[]{3, 8});
		deps.add(new Integer[]{4, 8});
		deps.add(new Integer[]{5, 8});
		deps.add(new Integer[]{6, 8});
		deps.add(new Integer[]{7, 8});
		deps.add(new Integer[]{2, 3});
		deps.add(new Integer[]{2, 4});
		deps.add(new Integer[]{5, 4});
		deps.add(new Integer[]{7, 6});
		deps.add(new Integer[]{6, 2});
		deps.add(new Integer[]{6, 3});
		deps.add(new Integer[]{6, 5});
		deps.add(new Integer[]{5, 9});
		deps.add(new Integer[]{9, 8});
		deps.add(new Integer[]{8, 0});
		deps.add(new Integer[]{4, 0});
		deps.add(new Integer[]{5, 0});
		deps.add(new Integer[]{9, 0});
		deps.add(new Integer[]{2, 0});
		deps.add(new Integer[]{3, 9});
		deps.add(new Integer[]{3, 10});
		deps.add(new Integer[]{10, 11});
		deps.add(new Integer[]{11, 12});
		deps.add(new Integer[]{2, 12});

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

		if(! jobs.contains(0)) {
			for(Integer [] arr : deps) {
				graph[arr[0]-1].add(arr[1]-1);
			}
		}
		else {
			for(Integer [] arr : deps) {
				graph[arr[0]].add(arr[1]);
			}
		}

		if(isGraphCyclic(graph)) {
			return new ArrayList<Integer>();
		}

		boolean visited [] = new boolean[jobs.size()];
		for(int i = 0; i < jobs.size();i++){
			if(!visited[i]) {
				sort(i, visited, jobs, graph, stack);
			}
		}

		for(int j = 0 ;j<stack.size();j++) {
			if(jobs.contains(0)) {
				list.add(stack.pop());
			}
			else {
				list.add(stack.pop()+1);
			}

		}
		while(!stack.isEmpty()) {
			if(jobs.contains(0)) {
				list.add(stack.pop());
			}
			else {
				list.add(stack.pop()+1);
			}

		}

		return list;
	}




	public static boolean isGraphCyclic(ArrayList<Integer> [] graph) {

		boolean [] visited = new boolean[graph.length];
		Set<Integer> ancestors = new HashSet<Integer>();
		boolean flag = false;

		for(int i = 0;i< graph.length;i++) {
			flag = isCyclic(graph, i, visited, ancestors); 
			if(flag) {
				break;
			}
		}

		return flag;

	}

	public static boolean isCyclic(ArrayList<Integer> [] graph, Integer vertex, boolean [] visited, Set<Integer> ancestors) {
		boolean flag = false;
		visited[vertex] = true;
		if(ancestors.contains(vertex)) {
			return true;
		}
		ancestors.add(vertex);
		for(Integer child: graph[vertex]) {

			//if(!visited[child]) {
			flag = isCyclic(graph, child, visited, ancestors);
			if(flag) return true;
			//}
		}
		ancestors.remove(vertex);
		return false;

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




class Program {
	
	
	public static void main(String args[]) {
		BST b = new BST(10);
		b.left = new BST(5);
		
		b.remove(10);
		
		System.out.println(b);
	}
	
	static class BST {
	    public int value;
	    public BST left;
	    public BST right;

	    public BST(int value) {
	      this.value = value;
	    }

	    public BST insert(int value) {
	      return insert(this, value);
	    }
	    
	    private BST insert(BST node, int value) {
	    	BST prev = null;
	    	BST cur = node;
	    	BST newNode = new BST(value);
	    	
	    	while(cur != null) {
	    		prev = cur;
	    		if(value < cur.value) {
	    			cur = cur.left;
	    		}
	    		else {
	    			cur = cur.right;
	    		}
	    	}
	    	if(prev == null) {
	    		node = newNode;
	    	}
	    	else {
	    		if(prev.value > value) {
	    			prev.left = newNode;
	    		}
	    		else {
	    			prev.right = newNode;
	    		}
	    	}
	    	return node;
	    }

	    public boolean contains(int value) {
	      return contains(this, value);
	    }
	    private boolean contains(BST node, int value) {
	    	BST cur = node;
	    	while(cur != null) {
	    		if(cur.value == value) {
	    			return true;
	    		}
	    		else if(cur.value > value) {
	    			cur = cur.left;
	    		}
	    		else {
	    			cur = cur.right;
	    		}
	    	}
	    	return false;
	    }
	    public BST remove(int value) {
	    	if(this.left == null && this.right == null) {
	    		return this;
	    	}
	    	return remove(this, value);
	    }
	    private BST remove(BST node, int value) {
	    	if(node == null) {
	    		return node;
	    	}
	    	if(node.value > value) {
	    		node.left = remove(node.left, value);
	    	}
	    	else if(node.value < value) {
	    		node.right = remove(node.right, value);
	    	}
	    	else {
	    		if(node.left == null) return node.right;
	    		else if(node.right == null) return node.left;
	    		else {
	    			node.value = min(node.right);
	    			node.right = remove(node.right, node.value);
	    		}
	    	}
	    	return node;
	    }
	    private int min(BST node) {
	    	if(node.left != null) {
	    		return min(node.left);
	    	}
	    	else {
	    		return node.value;
	    	}
	    }
	}
}


