package com.practice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class GraphCloneGraph3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Node cloneGraph(Node node) {
		if(node == null) return null;
		Node visited [] = new Node[101];
		Queue<Node[]> q = new LinkedList<Node[]>();
		Node copy = new Node(node.val);
		bfsUtil(node, copy, visited, q);
		return copy;
	}

	private void bfsUtil(Node node, Node copy, Node[] visited, Queue<Node[]> q) {
		visited[node.val] = copy;
		q.add(new Node[] {node, copy});
		while( !q.isEmpty()) {
			Node [] curArr = q.poll();
			Node cur = curArr[0];
			Node curCopy = curArr[1];
			for(Node neighbor : cur.neighbors) {
				if(visited[neighbor.val] == null) {
					Node copiedNeighbor = new Node(neighbor.val);
					visited[neighbor.val] = copiedNeighbor;
					curCopy.neighbors.add(copiedNeighbor);
					q.add(new Node[] {neighbor, copiedNeighbor});
				}
				else {
					curCopy.neighbors.add(visited[neighbor.val]);
				}
			}	
		}
		System.gc();
	}

}
