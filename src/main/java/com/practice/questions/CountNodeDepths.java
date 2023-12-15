package com.practice.questions;

public class CountNodeDepths {

	// https://www.algoexpert.io/questions/evaluate-expression-tree
	public static int nodeDepths(BinaryTree root) {
		int sum = 0;
		int depth = 0;
		sum = count(root, sum, depth);
		return sum;
	}

	public static int count(BinaryTree node, int sum, int depth) {
		sum = sum+depth;
		if(node.left != null) {
			sum = count(node.left, sum, depth+1);
		}
		if(node.right != null) {
			sum = count(node.right, sum, depth+1);
		}
		return sum;
	}


	static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}

}
