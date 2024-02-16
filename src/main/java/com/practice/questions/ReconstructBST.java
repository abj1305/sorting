package com.practice.questions;

import java.util.ArrayList;
import java.util.List;

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
		ArrayList<Integer> list = new  ArrayList();
		list.add(10);
		list.add(4);
		list.add(2);
		list.add(1);
		list.add(5);
		list.add(17);
		list.add(19);
		list.add(18);
		ReconstructBST r = new ReconstructBST();
		r.reconstructBst(list);
	}
	
	public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
		return reconstruct(preOrderTraversalValues, 0, preOrderTraversalValues.size()-1);
	}
	
	public BST reconstruct(ArrayList<Integer> preOrderTraversalValues, int start, int end) {
		if(start > end || start >= preOrderTraversalValues.size() || end >= preOrderTraversalValues.size()) return null;
		BST node = new BST(preOrderTraversalValues.get(start));
		int rs = -1;
		for(int i = start+1 ; i < preOrderTraversalValues.size(); i++) {
			if(preOrderTraversalValues.get(i) > node.value) {
				rs = i;
				break;
			}
		}
		node.left = reconstruct(preOrderTraversalValues, start+1, rs-1);
		node.right = reconstruct(preOrderTraversalValues, rs, end);
		return node;
	}
}
