package com.practice.leetcode;

import java.util.Scanner;

public class BSTToGST {

	static int sum = 0;
	static Scanner sc = null;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(3);
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(8);
		
		BSTToGST b = new BSTToGST();
		root = b.bstToGst(root);
		System.out.println(root);
	}
	
    public TreeNode bstToGst(TreeNode root) {
    	sum = 0;
    	getAllSum(root);
    	replace(root);
        return root;
        
    }
    
    private void getAllSum(TreeNode node) {
    	if(node == null) return;
    	getAllSum(node.left);
    	sum = sum+node.val;
    	getAllSum(node.right);
    }
    
    private void replace(TreeNode node) {
    	if(node == null) return;
    	replace(node.left);
    	int tmp = node.val;
    	node.val = sum;
    	sum = sum-tmp;
    	replace(node.right);
    }

}
