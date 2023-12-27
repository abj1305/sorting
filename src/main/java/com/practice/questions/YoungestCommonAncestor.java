package com.practice.questions;

import java.util.Stack;

//https://www.algoexpert.io/questions/youngest-common-ancestor
public class YoungestCommonAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static AncestralTree getYoungestCommonAncestor(
			AncestralTree topAncestor,
			AncestralTree descendantOne,
			AncestralTree descendantTwo
			) {
		
		Stack<AncestralTree> ancestorsOne = new Stack<AncestralTree>();
		Stack<AncestralTree> ancestorsTwo = new Stack<AncestralTree>();
		
		AncestralTree tree = descendantOne;
		ancestorsOne.add(tree);
		
		while(tree.ancestor != null) {
			ancestorsOne.add(tree.ancestor);
			tree = tree.ancestor;
		}
		
		tree = descendantTwo;
		ancestorsTwo.add(tree);
		while(tree.ancestor != null) {
			ancestorsTwo.add(tree.ancestor);
			tree = tree.ancestor;
		}
		tree = null;
		System.gc();
		
		AncestralTree lastparent = null;
		while(!ancestorsOne.isEmpty() && !ancestorsTwo.isEmpty()) {
			AncestralTree aOne = ancestorsOne.pop();
			AncestralTree aTwo = ancestorsTwo.pop();
			if(aOne.name == aTwo.name) {
				lastparent = aOne;
			}
			else {
				break;
			}	
		}
		return lastparent;
	}

	static class AncestralTree {
		public char name;
		public AncestralTree ancestor;

		AncestralTree(char name) {
			this.name = name;
			this.ancestor = null;
		}

		// This method is for testing only.
		void addAsAncestor(AncestralTree[] descendants) {
			for (AncestralTree descendant : descendants) {
				descendant.ancestor = this;
			}
		}
	}
}		