package com.practice.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BSTInfected {

	public static void main(String args []) {
		TreeNode root = new TreeNode(1);
		//		root.left = new TreeNode(5);
		//		root.left.right = new TreeNode(4);
		//		root.left.right.left = new TreeNode(9);
		//		root.left.right.right = new TreeNode(2);
		//		root.right = new TreeNode(3);
		//		root.right.left = new TreeNode(10);
		//		root.right.right = new TreeNode(10);
		//TreeNode root = new TreeNode(1);

		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.left.right = new TreeNode(5);
		root.right.right = new TreeNode(4);

		BSTInfected i = new BSTInfected();
		int n = i.amountOfTime(root, 4);
		System.out.println(n);


	}

	public int amountOfTime(TreeNode root, int start) {
		Map<Integer, Set<Integer>> map = new HashMap<>();  
        convert(root, 0, map);
        Queue<Integer> queue = new LinkedList<>(); 
        queue.add(start);
        int minute = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
          
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize > 0) {
                int current = queue.poll();
                for (int num : map.get(current)) {
                    if (!visited.contains(num)) {
                        visited.add(num);
                        queue.add(num);
                    }
                }
                levelSize--;
            }
            minute++;
        }
        return minute - 1;

	}

	public void convert(TreeNode current, int parent, Map<Integer, Set<Integer>> map){
		if (current == null) {
			return;
		} 
		if (!map.containsKey(current.val)) {
			map.put(current.val, new HashSet<>());
		} 
		Set<Integer> adjacentList = map.get(current.val);
		if (parent != 0) {
			adjacentList.add(parent);
		} 
		if (current.left != null) {
			adjacentList.add(current.left.val);
		} 
		if (current.right != null) {
			adjacentList.add(current.right.val);
		} 
		convert(current.left, current.val, map);
		convert(current.right, current.val, map);
	}         

}
