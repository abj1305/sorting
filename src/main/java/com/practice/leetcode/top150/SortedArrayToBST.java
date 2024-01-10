package com.practice.leetcode.top150;


public class SortedArrayToBST {

	public static void main(String[] args) {
		SortedArrayToBST s = new SortedArrayToBST();
		TreeNode root = s.sortedArrayToBST(new int[] {-10,-3,0,5,9});
		System.out.println(root);
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST(nums, 0, nums.length-1);
	}

	public TreeNode sortedArrayToBST(int [] nums, int l, int r) {
		if(l>r) {
			return null;
		}
		int mid = l + (r-l)/2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(nums, l, mid-1);
		root.right = sortedArrayToBST(nums, mid+1, r);
		return root;

	}
	
}
