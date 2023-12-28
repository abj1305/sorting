package com.practice.questions;

import java.util.ArrayList;
import java.util.List;

public class KthLargestElementInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findKthLargestValueInBst(BST tree, int k) {
		List<Integer> list = new ArrayList<Integer>();
		inOrder(tree, list);
		return list.get(list.size() - k -1);
	}


	public List<Integer> inOrder(BST node, List<Integer> list) {
		if(node == null) {
			return list;
		}
		inOrder(node.left, list);
		list.add(node.value);
		inOrder(node.right, list);
		return list;
	}

	static class BST {
		public int value;
		public BST left = null;
		public BST right = null;

		public BST(int value) {
			this.value = value;
		}
	}
}
