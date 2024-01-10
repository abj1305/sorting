package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static List<Integer> list1;
	static List<Integer> list2;
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		
		list1 = new ArrayList<Integer>();
		list2 = new ArrayList<Integer>();
		inOrder(root1, true);
		inOrder(root2, false);
		if(list1.size() != list2.size()) {
			return false;
		}
		for(int i = 0 ; i < list1.size(); i++) {
			if(! list1.get(i).equals(list2.get(i))) {
				return false;
			}
		}
		return true;
    }
	
	private void inOrder(TreeNode node, boolean isFirst) {
		if (node == null) return;
		inOrder(node.left, isFirst);
		if(node.left == null && node.right == null) {
			if(isFirst) list1.add(node.val);
			else list2.add(node.val);
		}
		inOrder(node.right, isFirst);
	}

}
