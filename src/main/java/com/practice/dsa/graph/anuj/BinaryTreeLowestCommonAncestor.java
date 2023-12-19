package com.practice.dsa.graph.anuj;

import java.util.Scanner;

public class BinaryTreeLowestCommonAncestor {

static Scanner sc = null;
	
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
		
		System.out.println("Enter left for " + data+": ");
		node.left = createTree();
		
		System.out.println("Enter right for " + data+": ");
		node.right = createTree();
		
		return node;
	}
	
	public static Node lca(Node root, int a, int b) {
		if(root ==null) return null;
		
		if(root.data == a || root.data ==b) {
			return root;
		}
		
		Node left = lca(root.left, a, b);
		Node right = lca(root.right, a, b);
		
		if(left == null) return right;
		if(right == null) return left;
		
		return root;
	}

}
