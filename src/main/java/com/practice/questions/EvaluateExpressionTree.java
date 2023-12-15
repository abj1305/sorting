package com.practice.questions;

public class EvaluateExpressionTree {

	// This is an input class. Do not edit.
	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	//https://www.algoexpert.io/questions/evaluate-expression-tree
	public int evaluateExpressionTree(BinaryTree tree) {
		int value = 0;
		value = evaluate(tree, value);
		return value;
	}

	public int evaluate(BinaryTree node, int value) {
		if(node.left == null && node.right == null) {
			return node.value;
		}
		if(node.left == null && node.right != null) {
			return node.right.value;
		}
		if(node.left != null && node.right == null) {
			return node.left.value;
		}
		
		switch(node.value) {
		case -1:
			return evaluate(node.left, value) + evaluate(node.right, value);
		case -2:
			return evaluate(node.left, value) - evaluate(node.right, value);
		case -3:
			return evaluate(node.left, value) / evaluate(node.right, value);
		case -4:
			return evaluate(node.left, value) * evaluate(node.right, value);
		}
		
		return value;
	}

}
