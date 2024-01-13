package com.practice.leetcode.top150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeLevelOrderTraversal {
	
	private int height(TreeNode node) {
		if(node == null) return 0;
		return Math.max(height(node.left), height(node.right)) + 1;
	}
	
    public List<List<Integer>> levelOrder(TreeNode root) {
    	if(root == null) return new ArrayList<List<Integer>>();
    	int maxHeight = height(root);
    	Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    	for(int i = 0; i < maxHeight ; i++) {
    		map.put(i, new ArrayList<>());
    	}
    	fillMap(root, map, 0);
    	
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	for(int i=0; i< map.size() ; i++) {
    		ans.add(map.get(i));
    	}
    	return ans;
    	
    }

    
    private void fillMap(TreeNode node, Map<Integer, List<Integer>> map, int ht) {
    	if(node == null) return;
    	map.get(ht).add(node.val);
    	fillMap(node.left, map, ht+1);
    	fillMap(node.right, map, ht+1);
    }
}
