package com.practice.leetcode.top150;




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

public class KthSmallestInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	static int counter;
	static int ans;
	public int kthSmallest(TreeNode root, int k) {
		counter = 0;
		ans = -1;
		inOrder(root, k);
		return ans;
		
	}
	public void inOrder(TreeNode node, int k) {
		if(node == null || ans != -1) return;
		inOrder(node.left, k);
		if(++ counter == k) {
			ans =  node.val;
		}
		inOrder(node.right, k);
	}

}
