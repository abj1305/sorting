package com.practice.dsa.anuj.bst;

import java.util.Scanner;

class Node {

	public int data;
	public Node left;
	public Node right;

	public Node(int data) {
		this.data = data;
	}
}

public class BST {

	
	static Scanner sc;           
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Node root = createTree();
		System.out.println();
		System.out.println("___________________________________");
		deleteNode(root, 6);
		System.out.println();
		System.out.println("___________________________________");
		printInOrder(root);
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
	
	public static void printInOrder(Node root) {
		if(root == null) return;
		printInOrder(root.left);
		System.out.print(root.data + " ");
		printInOrder(root.right);
	}
	
	public static boolean search(Node root, int x) {
		if(root==null) return false;
		if(root.data == x) return true;
		if(root.data < x) 
			return search(root.right, x);
		return search(root.right, x);
	}
	
	public static Node insert(Node root, int x) {
		if(root == null) {
			root = new Node(x);
			return root;
		}
		if(root.data > x) {
			root.left = insert(root.left, x);
		}
		else if(root.data < x) {
			root.right = insert(root.right, x);
		}
		return root;
	}
	
	public static Node insertRecursively(Node root, int x) {
		Node newNode = new Node(x);
		Node cur = root;
		Node parent = null;
		
		while(cur != null) {
			parent = cur;
			if(x < cur.data) {
				cur = cur.left;
			}
			else {
				cur = cur.right;
			}
		}
		if(parent == null) {
			parent = newNode;
		}
		else if(x < parent.data) {
			parent.left = newNode;
		}
		else {
			parent.right = newNode;
		}
		return root;
		
		
	}
	
	public static int min(Node root) {
		if(root.left != null) {
			return min(root.left);
		}
		else {
			return root.data;
		}
		
	}
	
	public static Node deleteNode(Node root, int key) {
		if(root == null) return null;
		if(key < root.data) {
			root.left = deleteNode(root.left, key);
		}
		else if(key > root.data) {
			root.right = deleteNode(root.right, key);
		}
		else {
			// easier case
			if(root.left == null) {
				return root.right;
			}
			else if(root.right == null) {
				return root.left;
			}
			// if node has both the nodes
			else {
				root.data = min(root.right);
				root.right = deleteNode(root.right, root.data);
			}
		}
		return root;
	}
	
}
