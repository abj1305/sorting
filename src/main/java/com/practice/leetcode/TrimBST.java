package com.practice.leetcode;

public class TrimBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public TreeNode trimBST(TreeNode root, int low, int high) {
		if(root == null) return null;
		
		root.left = trimBST(root.left, low, high);
		root.right = trimBST(root.right, low, high);
		
		if(root.val < low) {
			root.left = null;
			return root.right;
		}
		
		if(root.val > high) {
			root.right = null;
			return root.left;
		}
		
		return root;
	}

}
