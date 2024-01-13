package com.practice.leetcode.top150;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeAvgLevels {

	private int height(TreeNode node) {
		if(node == null) return 0;
		return Math.max(height(node.left), height(node.right)) + 1;
	}
	
    public List<Double> averageOfLevels(TreeNode root) {
    	DecimalFormat df=new DecimalFormat("#.#####");
    	if(root == null) return new ArrayList<Double>();
    	int maxHeight = height(root);
    	Map<Integer, List<Double>> map = new HashMap<Integer, List<Double>>();
    	for(int i = 0; i < maxHeight ; i++) {
    		map.put(i, new ArrayList<>());
    	}
    	fillMap(root, map, 0);
    	List<Double> ans = new ArrayList<Double>();
    	for(int i = 0; i < maxHeight ; i++) {
    		double sum = 0;
    		for(double d : map.get(i)) {
    			sum += d;
    		}
    		ans.add( Double.valueOf(df.format((double) sum/map.get(i).size())));
    	}
    	return ans;
    }
    
    private void fillMap(TreeNode node, Map<Integer, List<Double>> map, int ht) {
    	if(node == null) return;
    	map.get(ht).add((double)node.val);
    	fillMap(node.left, map, ht+1);
    	fillMap(node.right, map, ht+1);
    }
	
}
