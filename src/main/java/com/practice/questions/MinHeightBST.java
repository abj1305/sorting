package com.practice.questions;

import java.util.List;

public class MinHeightBST {

	public static void main(String args []) {
		List<Integer> list = List.of(1,2,5,7,10,13,14,15,22);
		BST node = minHeightBst(list);
		System.out.println(node);
	}

	public static BST minHeightBst(List<Integer> array) {
		BST head = minHeightBST(array, 0, array.size()-1);
		return head;
	}
	
	public static BST minHeightBST(List<Integer> array, int min, int max) {
		if(min>max) {
			return null;
		}
		int mid = (min+max)/2;
		BST node = new BST(array.get(mid));
		node.left = minHeightBST(array, min, mid-1);
		node.right = minHeightBST(array, mid+1, max);
		
		return node;
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
			left = null;
			right = null;
		}

		public void insert(int value) {
			if (value < this.value) {
				if (left == null) {
					left = new BST(value);
				} else {
					left.insert(value);
				}
			} else {
				if (right == null) {
					right = new BST(value);
				} else {
					right.insert(value);
				}
			}
		}
	}

}
