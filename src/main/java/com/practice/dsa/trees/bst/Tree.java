package com.practice.dsa.trees.bst;

public class Tree {
	
	private TreeNode root;
	
	public void insert(int value) {
		if(null == root) {
			root = new TreeNode(value);
		}
		else {
			root.insert(value);
		}
	}
	
	public void traverseInOrder() {
		if(null != root) {
			root.traverseInOrder();
		}
	}
	
	public void traversePreOrder() {
		if(null != root) {
			root.traversePreOrder();
		}
	}
	
	public TreeNode get(int value) {
		if(null != root) {
			return root.get(value);
		}
		return null;
	}
	
	public int min() {
		if(root != null) {
			return root.min();
		}
		else {
			return Integer.MIN_VALUE;
		}
	}
	
	public int max() {
		if(root != null) {
			return root.max();
		}
		else {
			return Integer.MAX_VALUE;
		}
	}
	
	public void delete(int value) {
		root = delete(root, value);
	}

	private TreeNode delete(TreeNode subtreeRoot, int value) {
		if(null == subtreeRoot) {
			return subtreeRoot;
		}
		if(value < subtreeRoot.getData()) {
			subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
		}
		else  if(value > subtreeRoot.getData()) {
			subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
		}
		else {
			// case 1 and 2 : node to delete has 0 to 1 child(ren)
			if(subtreeRoot.getLeftChild() == null) {
				return subtreeRoot.getRightChild();
			}
			else if(subtreeRoot.getRightChild() == null) {
				return subtreeRoot.getLeftChild();
			}
			//case 3: node to delete has 2 children 
			
			//Replace the value of subtreeRoot with the smallest value 
			// from the right sub tree
			subtreeRoot.setData(subtreeRoot.getRightChild().min());
			
			
			//delete the Node with smallest value from the right subtree
			subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
		}
		
		return subtreeRoot;
	}

}
