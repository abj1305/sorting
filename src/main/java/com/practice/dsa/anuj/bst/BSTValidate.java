package com.practice.dsa.anuj.bst;

import java.util.Scanner;

public class BSTValidate {

	static Scanner sc;           
	static int prev = Integer.MIN_VALUE;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Node root = createTree();
		boolean b = isBstUsingRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(b);
		
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
	
	public static boolean isBstUsingInOrderTraversal(Node root) {
		if(root!=null) {
			if(!isBstUsingInOrderTraversal(root.left)) {
				return false;
			}
			if(root.data <= prev) {
				return false;
			}
			prev = root.data;
			return isBstUsingInOrderTraversal(root.right);
		}
		return true;
		
	}
	
	public static boolean isBstUsingRange(Node root, int min, int max) {
		if(root == null) {
			return true;
		}
		if(root.data < min || root.data > max) {
			return false;
		}
		return(
				isBstUsingRange(root.left, min, root.data-1) &&
				isBstUsingRange(root.right, root.data+1, max)
				);
	}

}
