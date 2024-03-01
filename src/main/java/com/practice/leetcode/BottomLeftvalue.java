package com.practice.leetcode;

public class BottomLeftvalue {
	
	public static void main(String args []) {
		BottomLeftvalue blv = new BottomLeftvalue();
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		
		int i = blv.findBottomLeftValue(root);
		System.out.println(i);
		
	}
	
    public int findBottomLeftValue(TreeNode root) {
    	int ht = height(root);
    	Integer [] leftMost = new Integer [ht];
    	inOrder(root, 0, leftMost);
    	return leftMost[ht-1];
    }
    
    private int height (TreeNode node) {
    	if(node == null) return 0;
    	return Math.max(height(node.left), height(node.right)) + 1;
    }
    
    private void inOrder(TreeNode node, int h, Integer [] ht) {
    	if(node == null) return;
    	inOrder(node.left, h+1, ht);
    	if(ht[h] == null) {
    		ht[h] = node.val;
    	}
    	inOrder(node.right, h+1, ht);
    }

}
