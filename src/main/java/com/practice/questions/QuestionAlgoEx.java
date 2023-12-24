package com.practice.questions;

import java.util.List;

public class QuestionAlgoEx {

	public static void main(String args[]) {
		validateBst(new BST(4));
	}

	public static boolean validateBst(BST tree) {


		tree.left = new BST(2);
		tree.left.left = new BST(1);
		tree.left.right = new BST(3);
		tree.right = new BST(6);
		tree.right.left = new BST(5);
		tree.right.right = new BST(7);

		return validate(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean validate(BST node, int min, int max) {
		if(node == null) {
			return true;
		}
		if(!validate(node.left, min, node.value)) {
			return false;
		}
		if(node.value < min || node.value >= max) {
			return false;
		}
		return validate(node.right, node.value, max);
	}

	public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
		if(tree == null) return array;
		inOrderTraverse(tree.left, array);
		if(tree!=null) {
			array.add(tree.value);
		}
		inOrderTraverse(tree.right, array);
		return array;
	}

	public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
		if(tree == null) return array;
		if(tree!=null) {
			array.add(tree.value);
		}
		preOrderTraverse(tree.left, array);
		preOrderTraverse(tree.right, array);
		return array;
	}

	public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
		if(tree == null) return array;
		postOrderTraverse(tree.left, array);
		postOrderTraverse(tree.right, array);
		if(tree!=null) {
			array.add(tree.value);
		}
		return array;
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}
	}

}
