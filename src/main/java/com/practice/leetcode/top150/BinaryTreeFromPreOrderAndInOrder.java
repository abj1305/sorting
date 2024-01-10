package com.practice.leetcode.top150;

import java.util.HashMap;

public class BinaryTreeFromPreOrderAndInOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int preorderInder = 0;
	private TreeNode construct(int[] preorder, int left, int right, HashMap<Integer, Integer> map) {
		if(left > right) return null;
		int pVal = preorder[preorderInder];
		int index = map.get(pVal);
		
		TreeNode node = new TreeNode(pVal);
		preorderInder ++;
		node.left = construct(preorder, left, index-1,map);
		node.right = construct(preorder, index+1, right, map);
		return node;

	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		preorderInder = 0;
		HashMap<Integer,Integer> map = new HashMap<>();
		int len = inorder.length;
		for(int i=0;i<len;i++){
			map.put(inorder[i],i);
		}
		return construct(preorder, 0, len-1, map);
	}



}
