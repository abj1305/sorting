package com.practice.leetcode;

public class RangeSumBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int count = 0;
	public int rangeSumBST(TreeNode root, int low, int high) {
		count = 0;
		inOrder(root, low, high);
		return count;
		
	}

	
	private void inOrder(TreeNode node, int low, int high) {
		if(node == null) return;
		inOrder(node.left, low, high);
		if(node.val >= low && node.val <=high) {
			count = count + node.val;
		}
		inOrder(node.right, low, high);
	}

}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
