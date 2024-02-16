package com.practice.questions;

public class MergeBinaryTree {
	
	// This is an input class. Do not edit.
	  static class BinaryTree {
	    public int value;
	    public BinaryTree left = null;
	    public BinaryTree right = null;

	    public BinaryTree(int value) {
	      this.value = value;
	    }
	  }
	  
	  public static void main(String args[]) {
		  
	  }

	  public BinaryTree mergeBinaryTrees(BinaryTree tree1, BinaryTree tree2) {
	    if(tree1 == null && tree2 == null) {
	    	return null;
	    }
	    BinaryTree node ;
	    
	    if(tree1 !=null && tree2 == null) {
	    	node = new BinaryTree(tree1.value);
	    	node.left = mergeBinaryTrees(tree1.left, null);
	    	node.right = mergeBinaryTrees(tree1.right, null);
	    }
	    else if(tree1 ==null && tree2!=null) {
	    	node = new BinaryTree(tree2.value);
	    	node.left = mergeBinaryTrees(null, tree2.left);
	    	node.right = mergeBinaryTrees(null, tree2.right);
	    }
	    else {
	    	node = new BinaryTree(tree1.value + tree2.value);
	    	node.left = mergeBinaryTrees(tree1.left, tree2.left);
	    	node.right = mergeBinaryTrees(tree1.right, tree2.right);
	    }
	    
	    return node;
	  }

}
