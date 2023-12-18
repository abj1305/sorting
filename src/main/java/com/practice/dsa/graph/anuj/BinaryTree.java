package com.practice.dsa.graph.anuj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Node {

	public int data;
	public Node left;
	public Node right;

	public Node(int data) {
		this.data = data;
	}
}


public class BinaryTree {


	static Scanner sc = null;
	public static void main(String args []) {
		sc = new Scanner(System.in);
		Node root = createTree();
		System.out.println("InOrder");
		inOrder(root);
		System.out.println();
		System.out.println("PreOrder");
		preOrder(root);
		System.out.println();
		System.out.println("PostOrder");
		postOrder(root);
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("Height");
		System.out.println(
				height(root)
				);
		System.out.println("--------------------------------");
		System.out.println("Size");
		System.out.println(
				size(root)
				);
		System.out.println("--------------------------------");
		System.out.println("Max");
		System.out.println(
				max(root)
				);
		System.out.println("--------------------------------");
		System.out.println("Min");
		System.out.println(
				min(root)
				);

		System.out.println("--------------------------------");
		System.out.println("print using CurrentLevel method");
		for(int i =1 ;i <=height(root);i++ ) {
			printCurrentLevel(root, i);	
		}
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("printLevelOrder");
		printLevelOrder(root, true);
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("printLevelOrderUsingHashMap");
		printLevelOrderUsingHashMap(root);

	}

	public static Node createTree() {

		System.out.println("Enter data: ");
		int data = sc.nextInt();
		if(data == -1) {
			return null;
		}
		Node node = new Node(data);
		System.out.println("Enter left for " + data + ":");
		node.left = createTree();

		System.out.println("Enter right for " + data + ":");
		node.right = createTree();

		return node;

	}

	public static void inOrder(Node root) {
		if(root == null) return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	public static void preOrder(Node root) {
		if(root == null) return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	public static void postOrder(Node root) {
		if(root == null) return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}

	public static int height(Node root) {
		if(root == null) return 0;
		return Integer.max(height(root.left), height(root.right)) + 1;
	}

	public static int size(Node root) {
		if(root == null) {
			return 0;
		}

		return size(root.left) + size(root.right) + 1;
	}

	public static int max(Node root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}

		return Integer.max(root.data, 
				Integer.max(max(root.left), max(root.right))
				);
	}

	public static int min(Node root) {
		if(root == null) {
			return Integer.MAX_VALUE;
		}
		return Integer.min(root.data, 
				Integer.min(min(root.left),min(root.right))
				);

	}


	// Time complexity is O(n^2)
	public static void printCurrentLevel(Node root, int level) {
		if(root == null) {
			return;
		}
		if(level == 1) {
			System.out.print(root.data + " ");
		}
		else if(level > 1) {
			printCurrentLevel(root.left, level-1);
			printCurrentLevel(root.right, level-1);
		}
	}

	public static void printLevelOrder(Node root, boolean printLevelAtNewLine) {

		Queue<Node> queue = new LinkedList<Node>();

		queue.add(root);
		queue.add(null);

		while(! queue.isEmpty()) {
			Node curr = queue.poll();
			if(curr == null) {
				if(queue.isEmpty()) {
					return;
				}
				queue.add(null);
				System.out.println();
				continue;
			}
			System.out.print(curr.data + " ");
			if(curr.left != null) queue.add(curr.left);
			if(curr.right != null) queue.add(curr.right);
		}
	}

	public static void printLevelOrderUsingHashMap(Node root) {
		
		if(root == null) {
			return;
		}
		
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		
		int maxLevel = height(root);
		
		for(int i=0;i<maxLevel;i++) {
			map.put(i, new ArrayList<Integer>());
		}
		fillHashMap(root, map, 0);
		
		for(int i=0;i<maxLevel;i++) {
			System.out.println(map.get(i));
		}
		
	}
	
	private static void fillHashMap(Node node, Map<Integer, List<Integer>> map, int level) {
		if(node == null) return;
		map.get(level).add(node.data);
		if(node.left !=null) fillHashMap(node.left, map, level+1);
		if(node.right !=null) fillHashMap(node.right, map, level+1);
	}

}
