package com.practice.dsa.anuj.binarytree;

import java.util.Scanner;

public class BinaryTreeToDoublyLinkedList {

	static Scanner sc = null;
	static Node prev, head = null;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
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
	
	public static void convertToDLL(Node root) {
		if(root == null) return;
		convertToDLL(root.left);
		if(prev == null) head = root;
		else {
			prev.right = root;
			root.left = prev;
		}
		prev = root;
		convertToDLL(root.right);
	}

}
