package com.practice.leetcode.top150;

class TreeNodee {
	int val;
	TreeNodee left;
	TreeNodee right;
	TreeNodee() {}
	TreeNodee(int val) { this.val = val; }
	TreeNodee(int val, TreeNodee left, TreeNodee right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
		
		if (root==null || (root.left == null && root.right==null)) {
			return root;
		}
		
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		
		root.left = invertTree(root.left);
		root.right = invertTree(root.right);
		
		return root;
		
	}
	
}
