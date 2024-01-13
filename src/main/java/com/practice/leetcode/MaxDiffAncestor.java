package com.practice.leetcode;

import java.util.Stack;

public class MaxDiffAncestor {
	
	public static void main(String args[]) {
		
	}
	
	static int diff = 0; 
    public int maxAncestorDiff(TreeNode root) {
    	diff = 0;
        Stack<Integer> ancestors = new Stack<Integer>();
        maxDiff(root, ancestors);
        return diff;
    }
    
    private void maxDiff(TreeNode node, Stack<Integer> ancestors) {
    	if(node == null) return;
    	ancestors.stream().forEach(a -> {
    		if(Math.abs(a - node.val) > diff) {
    			diff = Math.abs(a - node.val);
    		}
    	});
    	ancestors.push(node.val);
    	maxDiff(node.left, ancestors);
    	maxDiff(node.right, ancestors);
    	ancestors.pop();
    }

}
