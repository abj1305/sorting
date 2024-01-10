package com.practice.leetcode.top150;

public class PathSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(7);
		PathSum p = new PathSum();
		boolean b = p.hasPathSum(root, 10);
		System.out.println(b);

	}

	public boolean hasPathSum(TreeNode root, int targetSum) {
		if(root == null) return false;
		if(root.left == null && root.right == null && targetSum == root.val) {
			return true;
		}
		if(hasPathSum(root.left, targetSum-root.val)) {
			return true;
		}
		if(hasPathSum(root.right, targetSum-root.val)) {
			return true;
		}
		return false;
	}

}
