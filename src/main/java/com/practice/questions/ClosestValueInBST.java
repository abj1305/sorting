package com.practice.questions;

public class ClosestValueInBST {

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {

	}


	static int closest = Integer.MAX_VALUE;
	public static int findClosestValueInBst(BST tree, int target) {
		travel(tree, target);
		return closest;
	}
	
	private static void travel2(BST tree, int target) {
		if(tree == null) return;
		if(Math.abs(tree.value - target) < Math.abs(closest - target)) {
			closest = tree.value;
		}
		if(target < tree.value) {
			travel(tree.left, target);
		}
		else {
			travel(tree.right, target);
		}
	}
	
	private static void travel(BST tree, int target) {
		while(tree != null) {
			if(Math.abs(tree.value - target) < Math.abs(closest - target)) {
				closest = tree.value;
			}
			if(target < tree.value) {
				tree = tree.left;
			}
			else {
				tree = tree.right;
			}
		}
	}

}
