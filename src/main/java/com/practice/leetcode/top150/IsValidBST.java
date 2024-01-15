package com.practice.leetcode.top150;

public class IsValidBST {
	
	public static void main(String args []) {
		TreeNode root = new TreeNode(2147483647);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(2);
		IsValidBST i = new IsValidBST();
		boolean b = i.isValidBST(root);
		System.out.println(b);
	}
	
	public boolean isValidBST(TreeNode root) {
		long min = Long.MIN_VALUE;
		long max = Long.MAX_VALUE;
		return isValidBST(root, min, max);
    }
	
	private boolean isValidBST(TreeNode node, long min, long max) {
		if(node == null) return true;
		if(node.val <= min || node.val >= max) {
			return false;
		}
		if(! isValidBST(node.left, min, node.val)) return false;
		return isValidBST(node.right, node.val, max);
	}
	
	
}
