package com.practice.dsa.anuj.bst;

import java.util.Scanner;

public class BSTCeilFloor {

	static Scanner sc;  
	
	
	public static void main(String[] args) {

		sc = new Scanner(System.in);
		Node root = createTree();
		int floor = floor(root, 25);
		int ceil = ceil(root, 25);
		
		System.out.println();
		System.out.println("--------------------------------------");
		System.out.println("Floor: " + floor);
		System.out.println("Ceil: " + ceil);
		
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
	
	public static int floor(Node node, int key) {
		int ans = Integer.MIN_VALUE;
		while(node != null) {
			
			if(node.data == key) {
				return node.data;
			}
			if(node.data > key) {
				node = node.left;
			} 
			else {
				ans = node.data;
				node = node.right;
			}
		}
		return ans;
	}
	
	public static int ceil(Node node, int key) {
		int ans = Integer.MAX_VALUE;
		while(node != null) {
			if(node.data == key) {
				return node.data;
			}
			if(node.data < key) {
				node = node.right;
			}
			else {
				ans = node.data;
				node = node.left;
			}
		}
		return ans;
	}
	
	

}
