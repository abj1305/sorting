package com.practice.leetcode.top150;




class TreeNode2 {
	int val;
	TreeNode2 left;
	TreeNode2 right;
	TreeNode2() {}
	TreeNode2(int val) { this.val = val; }
	TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
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
	public int kthSmallest(TreeNode2 root, int k) {
		counter = 0;
		ans = -1;
		inOrder(root, k);
		return ans;
		
	}
	public void inOrder(TreeNode2 node, int k) {
		if(node == null || ans != -1) return;
		inOrder(node.left, k);
		if(++ counter == k) {
			ans =  node.val;
		}
		inOrder(node.right, k);
	}

}
