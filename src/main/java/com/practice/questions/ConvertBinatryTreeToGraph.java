package com.practice.questions;

import java.util.ArrayList;
import java.util.List;

class TreeNodeee{
	public int val;
	public TreeNodeee left;
	public TreeNodeee right;
	public TreeNodeee(int val) {
		this.val = val;
	}
}

public class ConvertBinatryTreeToGraph {
	
	public static void main(String args[]) {
		TreeNodeee root = new TreeNodeee(1);
		root.left= new TreeNodeee(2);
		root.right= new TreeNodeee(3);
		root.left.left = new TreeNodeee(4);
		root.right.right = new TreeNodeee(7);
		convert(root);
	}
	
	public static void convert(TreeNodeee root) {
		int n = 10;
		List<List<Integer>> adj = new ArrayList<List<Integer>>();
		for(int i = 0 ; i <= n ; i++) {
			adj.add(i, new ArrayList<Integer>());
		}
		inOrder(root, -1, adj);
		System.out.println(adj);
	}
	
	public static void inOrder(TreeNodeee node, int parent, List<List<Integer>> adj) {
		if(node == null) return;
		inOrder(node.left, node.val, adj);
		if(parent != -1) {
			adj.get(parent).add(node.val);
		}
		inOrder(node.right, node.val, adj);
	}
	
	
}
