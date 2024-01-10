package com.practice.leetcode.top150;


public class SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }

	private boolean isMirror(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isMirror(left.right, right.left) && isMirror(left.left, right.right);
	}

}
