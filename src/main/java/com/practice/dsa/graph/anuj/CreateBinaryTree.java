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
		System.out.println(
				root
				);
	}
	
	public static Node createTree() {
		
		System.out.println("Enter data: ");
		int data = sc.nextInt();
		if(data == -1) {
			return null;
		}
		Node node = new Node(data);
		System.out.println("Enter left: ");
		node.left = createTree();
		
		System.out.println("Enter right: ");
		node.right = createTree();
		
		return node;
		
	}
	
	
	
}
