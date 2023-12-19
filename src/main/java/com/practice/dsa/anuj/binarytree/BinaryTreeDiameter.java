package com.practice.dsa.anuj.binarytree;

import java.util.Scanner;

public class BinaryTreeDiameter {

	static int ans;
	static Scanner sc = null;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Node root = createTree();
		
		System.out.println(
				diameterONSquare(root)
				);
		System.out.println(
				diameterWithHeight(root)
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

	public static int height(Node root) {
		if(root == null) return 0;
		return Integer.max(height(root.left), height(root.right)) + 1;
	}

	public static int diameterONSquare(Node root) {
		if(root == null) return 0;
		int dl = diameterONSquare(root.left);
		int dr = diameterONSquare(root.right);

		int cur = height(root.left) + height(root.right) + 1;

		return Integer.max(cur, Integer.max(dl, dr));
	}

	public static int diameterWithHeight(Node root) {
		if(root == null) return 0;
		int lh = diameterWithHeight(root.left);
		int rh = diameterWithHeight(root.right);
		
		ans = Math.max(ans, 1+lh+rh);
		return 1+ Math.max(lh, rh);
	}
	
	
}
