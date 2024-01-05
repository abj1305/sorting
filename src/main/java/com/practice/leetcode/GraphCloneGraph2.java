package com.practice.leetcode;

import java.util.Stack;


public class GraphCloneGraph2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Node cloneGraph(Node node) {
		if(node == null) return null;
		Node[]visited = new Node[101];
		Stack<Node[]> stack = new Stack<Node[]>();
		Node copy = new Node(node.val);
		dfsUtil(node, copy, visited, stack);
		return copy;
	}

	private void dfsUtil(Node node, Node copy, Node[] visited, Stack<Node[]> stack) {
		visited[node.val] = copy;
		stack.push(new Node[] {node, copy});
		while(! stack.isEmpty()) {
			Node [] curArr = stack.pop();
			Node cur = curArr[0];
			Node curCopy = curArr[1];
			for(Node neighbor : cur.neighbors) {
				if(visited[neighbor.val] == null) {
					Node copiedNeighbor = new Node(neighbor.val);
					curCopy.neighbors.add(copiedNeighbor);
					visited[neighbor.val] = copiedNeighbor;
					stack.push(new Node[] {neighbor, copiedNeighbor});
				}
				else {
					curCopy.neighbors.add(visited[neighbor.val]);
				}
			}
		}
		
	}

}
