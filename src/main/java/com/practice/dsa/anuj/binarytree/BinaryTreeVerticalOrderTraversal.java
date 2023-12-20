package com.practice.dsa.anuj.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Pairr {
	public int hd;
	public Node node;
	
	public Pairr(int hd, Node node) {
		this.hd = hd;
		this.node = node;
	}
}

public class BinaryTreeVerticalOrderTraversal {

	static Scanner sc = null;
	public static void main(String args[]) {
		sc = new Scanner(System.in);
		Node root = createTree();
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

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
	
	public static void verticalOrderTraversal(Node root, 
			Map<Integer, List<Integer>> map) {
		
		Queue<Pairr>  q = new LinkedList<Pairr>();
		if(root == null) return;
		
		q.add(new Pairr(0,root));
		
		while(! q.isEmpty()) {
			Pairr pair = q.poll();
			if(map.containsKey(pair.hd)) {
				map.get(pair.hd).add(pair.node.data);
			}
			else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(pair.node.data);
				map.put(pair, list);
			}
		}
		
	}

}
