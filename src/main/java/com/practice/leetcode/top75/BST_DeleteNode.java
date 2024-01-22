package com.practice.leetcode.top75;


public class BST_DeleteNode {
	
	public static int min(TreeNode root) {
		if(root.left != null) {
			return min(root.left);
		}
		else {
			return root.val;
		}
		
	}
	
    public TreeNode deleteNode(TreeNode root, int key) {
    	if(root == null) return root;
    	if(root.val > key) {
    		root.left = deleteNode(root.left, key);
    	}
    	else if(root.val < key) {
    		root.right = deleteNode(root.right, key);
    	}
    	else {
    		if(root.left == null) {
    			return root.right;
    		}
    		else if(root.right == null) {
    			return root.left;
    		}
    		else {
        		root.val = min(root.right);
        		root.right = deleteNode(root.right, root.val);
        		
    		}
    	}
    	return root;
    }

}
