package com.practice.dsa.anuj.bst;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BSTTwoSum {

	static Scanner sc;           
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Node root = createTree();
		twoSum(root, 12);
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
	
	public static void twoSum(Node root, int target) {
		Set<Integer> set = new HashSet<Integer>();
		boolean b = util(root, target, set);
		System.out.println(b);
	}
	
	public static boolean util(Node node, int target, Set<Integer> set) {
		if (node == null) return false;
		if(util(node.left, target, set)) {
			return true;
		}
		if(set.contains(target - node.data)) {
			return true;
		}
		set.add(node.data);
		
		return util(node.right, target, set);
		
	}
	
}
