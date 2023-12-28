package com.practice.questions;

import java.util.ArrayList;
import java.util.List;

public class FindInOrderSuccessor {


	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;
		public BinaryTree parent = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	public static void main(String args []) {
		BinaryTree tree = new BinaryTree(1);
//		tree.left = new BinaryTree(2);
//		tree.left.parent = tree;
//		tree.left.left = new BinaryTree(4);
//		tree.left.left.parent = tree.left;
//		tree.left.right = new BinaryTree(5);
//		tree.left.right.parent = tree.left;
//		tree.left.right.left = new BinaryTree(6);
//		tree.left.right.left.parent = tree.left.right;
//		tree.left.right.right = new BinaryTree(7);
//		tree.left.right.right.parent = tree.left.right;
//		tree.left.right.right.left = new BinaryTree(8);
//		tree.left.right.right.left.parent = tree.left.right.right;
//		tree.right = new BinaryTree(3);
//		tree.right.parent = tree;

		FindInOrderSuccessor s = new FindInOrderSuccessor();
		BinaryTree t = s.findSuccessor(tree, new BinaryTree(1));
		System.out.println(t == null ? -1 : t.value);
	}

	static List<BinaryTree> list = new ArrayList<BinaryTree>();
	static boolean getNow = false;
	static boolean ignore = false;
	public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
		list = new ArrayList<BinaryTree>();
		getNow = false;
		ignore = false;
		inOrder(tree, node);
		BinaryTree b = list.get(list.size()-1);
		return b.value == node.value ? null : b;
		
	}
	public void inOrder(BinaryTree tree, BinaryTree node) {
		if(tree == null) return;
		inOrder(tree.left, node);
		if(getNow) {
			list.add(tree);
			getNow = false;
			ignore = true;
		}
		else {
			if(! ignore) list.add(tree);
			if(! ignore && tree.value == node.value) {
				getNow = true;
			}
		}
		
		inOrder(tree.right, node);
	}
	
	//	public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
	//	    List<BinaryTree> list = new ArrayList<BinaryTree>();
	//	    list = inOrder(tree, list);
	//	    for(int i = 0 ; i < list.size()-1; i++) {
	//	    	if(list.get(i).value == node.value) {
	//	    		return list.get(i+1);
	//	    	}
	//	    }
	//	    return null;
	//	}
	//	
	//	public List<BinaryTree> inOrder(BinaryTree tree, List<BinaryTree> list) {
	//	    if(tree == null) {
	//	    	return list;
	//	    }
	//	    inOrder(tree.left, list);
	//	    list.add(tree);
	//	    inOrder(tree.right, list);
	//	    return list;
	//	}

}
