package com.practice.questions;

public class BSTClass {
	
	public static void main(String args[]) {
		BST root = new BST(1);
		root.right = new BST(2);
		root.right.right = new BST(3);
		root.right.right.right = new BST(4);
		
		root.remove(1);
		System.out.println(root);
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}

		public BST insert(int value) {
			return insert(this, value);
		}
		public BST insert(BST root, int value) {
			BST node = root;
			BST prev = null;
			while(node != null) {
				prev = node;
				if(node.value > value) {
					node = node.left;
				}
				else {
					node = node.right;
				}
			}
			if(prev == null) return new BST(value);
			if(prev.value > value) {
				prev.left = new BST(value);
			}
			else {
				prev.right = new BST(value);
			}
			return root;
		}

		public boolean contains(int value) {
			return contains(this, value);
		}

		public boolean contains(BST root, int value) {
			if(root == null) return false;
			BST node = root;
			while(node != null) {
				if(node.value == value) {
					return true;
				}
				else if(node.value > value) {
					node = node.left;
				}
				else {
					node = node.right;
				}
			}
			return false;
		}

		public BST remove(int value) {
			if(this.value == value && this.right == null && this.left == null) {
				return this;
			}
			
			BST root =  remove(this, value);
			this.value = root.value;
			this.left = root.left;
			this.right = root.right;
			return this;
		}
		
		public BST remove(BST root, int value) {
			if(root == null) return null;
			if(root.value > value) {
				root.left = remove(root.left, value);
			}
			else if(root.value < value) {
				root.right = remove(root.right, value);
			}
			else {
				if(root.right == null) {
					return root.left;
				}
				else if(root.left == null) {
					return root.right;
				}
				else {
					root.value = min(root.right);
					root.right = remove(root.right, root.value);
				}
			}
			return root;
		}
		
		private int min(BST root) {
			if(root.left != null) {
				return min(root.left);
			}
			return root.value;
		}
	}

}
