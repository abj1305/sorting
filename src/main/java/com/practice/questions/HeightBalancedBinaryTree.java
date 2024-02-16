package com.practice.questions;

public class HeightBalancedBinaryTree {

	// This is an input class. Do not edit.
	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	public boolean heightBalancedBinaryTree(BinaryTree tree) {
		if(tree == null) return true;
		if(Math.abs(height(tree.left) - height(tree.right)) > 1) return false;
		return heightBalancedBinaryTree(tree.left) && heightBalancedBinaryTree(tree.right);
	}
	
	private int height(BinaryTree node) {
		if(node == null) return 0;
		return Math.max(height(node.left), height(node.right)) + 1;
	}

}
