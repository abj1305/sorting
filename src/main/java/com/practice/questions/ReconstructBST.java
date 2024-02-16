package com.practice.questions;

import java.util.ArrayList;

public class ReconstructBST {
	static class BST {
		public int value;
		public BST left = null;
		public BST right = null;

		public BST(int value) {
			this.value = value;
		}
	}

	public static void main(String args[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(17);
		list.add(19);
		list.add(18);
		ReconstructBST r = new ReconstructBST();
		BST bst = r.reconstructBst(list);
		System.out.println(bst);
	}
	
	public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
		return reconstruct(preOrderTraversalValues, 0, preOrderTraversalValues.size()-1);
	}
	
	public BST reconstruct(ArrayList<Integer> preOrderTraversalValues, int start, int end) {
		if(start > end) return null;
		BST node = new BST(preOrderTraversalValues.get(start));
		int leftEnd = start;
		for(int i = start + 1 ; i <= end;i++) {
			if(preOrderTraversalValues.get(i) < node.value) {
				leftEnd = i;
			}
		}
		node.left = reconstruct(preOrderTraversalValues, start+1, leftEnd);
		node.right = reconstruct(preOrderTraversalValues, leftEnd+1, end);
		return node;
		
	}
}
