package com.practice.leetcode.top75;

import java.util.Map;
import java.util.TreeMap;

public class BST_MAxLevelSum {
	
	public static void main(String args[]) {
		BST_MAxLevelSum m = new BST_MAxLevelSum();
		TreeNode root = new TreeNode(989);
		root.right = new TreeNode(10250);
		root.right.left = new TreeNode(98693);
		root.right.right = new TreeNode(-89388);
		root.right.right.right = new TreeNode(-32127);
		int i = m.maxLevelSum(root);
		System.out.println(i);
	}

	public int maxLevelSum(TreeNode root) {
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		inOrder(root, 1, map);
		int maxLevel = 0;
		int maxVal = Integer.MIN_VALUE;
		for(int i : map.keySet()) {
			if(map.get(i) > maxVal) {
				maxVal = map.get(i);
				maxLevel = i;
			}
		}
		return maxLevel;
	}
	private void inOrder(TreeNode node, int level, Map<Integer, Integer> map) {
		if(node == null) return;
		if(map.containsKey(level)) {
			map.put(level, map.get(level) + node.val);
		}
		else {
			map.put(level, node.val);
		}
		inOrder(node.left, level+1, map);
		inOrder(node.right, level+1, map);
	}

}
