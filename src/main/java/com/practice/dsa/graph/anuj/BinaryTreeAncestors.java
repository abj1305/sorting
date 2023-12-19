package com.practice.dsa.graph.anuj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTreeAncestors {

	
	static Scanner sc = null;
	public static void main(String args[]) {
		sc = new Scanner(System.in);
		Node root = createTree();
		System.out.println(
				printAncestors(root, 1).toString()
				);
		
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
	
	public static Stack<Integer> printAncestors(Node root, int value) {
		Stack<Integer> list = new Stack<Integer>();
		list = getAncestors(root, value, list);
		return list;
	}
	
	public static Stack<Integer> getAncestors(Node root, int value, Stack<Integer> list) {
		if(root == null) return null;
		
		if(root.data == value) {
			return list;
		}
		list.push(root.data);
		Stack<Integer> ll = getAncestors(root.left, value, list);
		if(ll!=null) {
			return ll;
		}
		Stack<Integer> rl = getAncestors(root.right, value, list);
		if(rl!=null) {
			return rl;
		}
		list.pop();
		return null;
		
		
	}
	
}
