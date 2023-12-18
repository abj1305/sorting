package com.practice.dsa.graph.anuj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;


class Pair {
	public int hd;
	public Node node;
	
	public Pair(int hd, Node node) {
		this.hd = hd;
		this.node = node;
	}
}

public class BinaryTreeView {

	static Scanner sc = null;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Node root = createTree();
		viewLeft(root);
		System.out.println();
		System.out.println("--------------------------------");
		viewRight(root);
		System.out.println();
		System.out.println("--------------------------------");
		topView(root);
		System.out.println();
		System.out.println("--------------------------------");
		bottomView(root);
		

	}

	public static Node createTree() {
		System.out.println("Enter data: ");
		int data = sc.nextInt();
		if(data == -1) {
			return null;
		}
		Node node = new Node(data);
		
		System.out.println("Enter left for " + data+": ");
		node.left = createTree();
		
		System.out.println("Enter right for " + data+": ");
		node.right = createTree();
		
		return node;
	}
	
	public static int height(Node root) {
		if(root == null) return 0;
		return Integer.max(height(root.left), height(root.right))+1;
	}
	
	public static void viewLeft(Node root) {
		int maxLevel = height(root);
		int [] array = new int [maxLevel];
		for (int i=0;i<maxLevel;i++) {
			array[i] = -1;
		}
		left(root, 0, array);
		System.out.println(
				Arrays.toString(array)
				);
		
	}
	public static void left(Node node, int level, int [] array) {
		if(node == null) {
			return;
		}
		if(array[level] == -1) array[level] = node.data;
		left(node.left,level+1,array);
		left(node.right,level+1,array);
	}
	
	public static void viewRight(Node root) {
		int maxLevel = height(root);
		int [] array = new int [maxLevel];
		for (int i=0;i<maxLevel;i++) {
			array[i] = -1;
		}
		right(root, 0, array);
		System.out.println(
				Arrays.toString(array)
				);
		
	}
	
	public static void right(Node node, int level, int[] array) {
		if(node == null) return;
		if(array[level] == -1) array[level] = node.data;
		right(node.right, level+1, array);
		right(node.left, level+1, array);
	}
	
	public static void topView(Node root) {
		if(root == null) {
			return;
		}
		Queue <Pair> q = new LinkedList<Pair>();
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		q.add(new Pair(0, root));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			if(!map.containsKey(p.hd)) {
				map.put(p.hd, p.node.data);
			}
			if(p.node.left != null) {
				q.add(new Pair(p.hd-1, p.node.left));
			}
			if(p.node.right != null) {
				q.add(new Pair(p.hd+1, p.node.right));
			}
		}
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			ans.add(entry.getValue());
		}
		
		System.out.println(ans.toString());
	}
	
	public static void bottomView(Node root) {
		if(root == null) {
			return;
		}
		Queue <Pair> q = new LinkedList<Pair>();
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		q.add(new Pair(0, root));
		while(! q.isEmpty()) {
			Pair p = q.poll();
			map.put(p.hd, p.node.data);
			if(p.node.left != null) {
				q.add(new Pair(p.hd-1, p.node.left));
			}
			if(p.node.right != null) {
				q.add(new Pair(p.hd+1, p.node.right));
			}
		}
		List<Integer>list = new ArrayList<Integer>();
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			list.add(entry.getValue());
		}
		System.out.println(list.toString());
	}
	
}
