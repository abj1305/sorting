package com.practice.leetcode.top150;

public class MinimumAbsoluteBST {

	public static void main(String args[]) {
		
	}
	
	int min = 0;
	int prev = 0;
    public int getMinimumDifference(TreeNode root) {
    	min = Integer.MAX_VALUE;
    	prev = Integer.MAX_VALUE;
    	inOrder(root);
    	return min;
    }
    
    private void inOrder(TreeNode node) {
    	if(node == null) return;
    	inOrder(node.left);
    	min = Math.min(min, Math.abs(node.val-prev));
    	prev = node.val;
    	inOrder(node.right);
    }
	
}
