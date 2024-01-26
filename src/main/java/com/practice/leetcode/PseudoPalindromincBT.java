package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class PseudoPalindromincBT {

	static int ans = 0;
	static Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
	public int pseudoPalindromicPaths (TreeNode root) {
		ans = 0;
		map = new HashMap<Integer, Integer>();
		inOrder(root);
		return ans;
	}

	private void inOrder(TreeNode node) {
		if(node == null) return;
		addToMap(node.val);
		inOrder(node.left);
		if(node.left == null && node.right == null) {
			if(checkMap()) {
				ans++;
			}
		}
		inOrder(node.right);
		removeFromMap(node.val);
	}
	
	private void addToMap(int cur) {
		if(map.containsKey(cur)) {
			map.put(cur, map.get(cur)+1);
		}
		else {
			map.put(cur, 1);
		}
	}
	
	private void removeFromMap(int cur) {
		if(map.containsKey(cur)) {
			map.put(cur, map.get(cur)-1);
		}
		else {
			map.put(cur, 0);
		}
	}

	private boolean checkMap() {
		int oddCount = 0;
		for(int i : map.keySet()) {
			int v = map.get(i);
			if(v % 2 == 1) {
				oddCount++;
			}
		}
		if(oddCount == 0 || oddCount == 1) {
			return true;
		}
		else {
			return false;
		}
	}

}
