package com.practice.leetcode.top150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BinaryTreeRightSideView {
	
	public static void main(String args []) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
//		root.left.left = new TreeNode(5);
//		root.right = new TreeNode(3);
//		root.right.right = new TreeNode(4);
		BinaryTreeRightSideView r = new BinaryTreeRightSideView();
		List<Integer> list = r.rightSideView(root);
		System.out.println(list);
	}

	private static int height(TreeNode root) {
		if(root == null) return 0;
		return Integer.max(height(root.left), height(root.right)) + 1;
	}

	public List<Integer> rightSideView2(TreeNode root) {
		Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		int height = height(root);
		for(int i = 0 ;i <= height; i++) {
			map.put(i, new ArrayList<Integer>());
		}
		fillHashMap(root, map, 1);
		List<Integer> ans = new ArrayList<Integer>();
		for(int i = 1 ; i < map.size(); i++) {
			ans.add(map.get(i).get(map.get(i).size()-1));
		}
		return ans;
	}
	
	private void fillHashMap(TreeNode node, Map<Integer, List<Integer>> map, int height) {
		if(node == null) return;
		map.get(height).add(node.val);
		fillHashMap(node.left, map, height+1);
		fillHashMap(node.right, map, height+1);
	}
	
	public List<Integer> rightSideView(TreeNode root) {
		if(root == null) return new ArrayList<>(); 
		int maxHeight = height(root);
		int [] arr = new int[maxHeight];
		Arrays.fill(arr, -1);
		helper(root, 0, arr);
		List<Integer> ans = new ArrayList<Integer>();
		for(int i : arr) {
			ans.add(i);
		}
		return ans;
	}
	
	private void helper(TreeNode node, int height, int [] arr) {
		if(node == null) return;
		if(arr[height] == -1) arr[height] = node.val;
		helper(node.right, height+1, arr);
		helper(node.left, height+1, arr);
	}

}
