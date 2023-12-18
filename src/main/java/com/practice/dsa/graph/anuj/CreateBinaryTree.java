package com.practice.dsa.graph.anuj;

import java.util.Scanner;

class Node {
	
	public int data;
	public Node left;
	public Node right;

	public Node(int data) {
		this.data = data;
	}
}


public class CreateBinaryTree {
	
	
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
	
	
}
