package com.practice.leetcode.top75;

import java.util.ArrayList;
import java.util.List;

public class BT_RightView {

	
	private int height(TreeNode root) {
		if(root == null) return 0;
		return Math.max(height(root.left), height(root.right))+1;
	}
	public List<Integer> rightSideView(TreeNode root) {
		if(root == null) return new ArrayList<Integer>();
		int maxHeight = height(root);
		List<Integer>ans = new ArrayList<Integer>();
		for(int i = 0 ; i < maxHeight; i++) {
			ans.add(-1);
		}
		helper(ans, 0, root);
		return ans;
	}
	private void helper(List<Integer>ans, int height, TreeNode node) {
		if(node == null) return;
		if(ans.get(height) == -1) ans.set(height, node.val);
		helper(ans, height+1, node.right);
		helper(ans, height+1, node.left);
	}
}
