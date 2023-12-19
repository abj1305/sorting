package com.practice.dsa.anuj.binarytree;

import java.util.Scanner;


class Depth {
	public int d;
	public Depth(int d) {
		this.d = d;
	}
}

public class BinaryTreeBurn {
	
	static int ans = -1;
	static Scanner sc = null;

	public static void main(String[] args) {
		sc=new Scanner(System.in);
	}
	
	public static Node createTree() {
		System.out.println("Ender data: ");
		int data = sc.nextInt();
		if(data == -1) return null;
		Node root = new Node(data);
		System.out.println("Enter left for " + data+ ": ");
		root.left = createTree();
		System.out.println("Enter right for " + data+ ": ");
		root.right = createTree();
		return root;
	}

	public static int minTime(Node root, int target) {
		Depth depth = new Depth(-1);
		burn(root, target, depth);
		return ans;
	}

	private static int burn(Node root, int target, Depth depth) {

		if(root == null) return 0;
		if(root.data == target) {
			depth.d = 1;
			return 1;
		}
		Depth ld = new Depth(-1);
		Depth rd = new Depth(-1);
		
		int lh = burn(root.left, target, depth);
		int rh = burn(root.right, target, depth);
		
		if(ld.d != -1) {
			ans = Math.max(ans, 1 + ld.d+rh);
			depth.d = ld.d+1;
		}
		else if(rd.d != -1) {
			ans = Math.max(ans, 1 + lh + rd.d);
			depth.d = rd.d+1;
		}
		
		return Math.max(lh, rh) + 1;
	}
	
	
}
