package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

//Definition for a Node.
class Node {
	public int val;
	public List<Node> neighbors;
	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}
	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}
	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}


public class GraphCloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Node cloneGraph(Node node) {
		if(node == null) return null;
		Node[]visited = new Node[101];
		Node copy = new Node(node.val);
		dfsUtil(node, copy, visited);
		return copy;
	}

	private void dfsUtil(Node node, Node copy, Node[] visited) {
		visited[copy.val] = copy;
		for(Node neighbor : node.neighbors) {
			if(visited[neighbor.val] == null) {
				Node copiedNeighbor = new Node(neighbor.val);
				copy.neighbors.add(copiedNeighbor);
				dfsUtil(neighbor, copiedNeighbor, visited);
			}
			else {
				copy.neighbors.add(visited[neighbor.val]);
			}
		}
	}

}
