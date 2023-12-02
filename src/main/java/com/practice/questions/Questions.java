package com.practice.questions;

import java.util.*;

public class Questions {

	// Do not edit the class below except
	// for the depthFirstSearch method.
	// Feel free to add new properties
	// and methods to the class.
	static class Node {
		String name;
		List<Node> children = new ArrayList<Node>();

		public Node(String name) {
			this.name = name;
		}
		public List<String> depthFirstSearch(List<String> array) {
			array.add(name);
			children.stream().forEach(e -> e.depthFirstSearch(array));
			return array;
		}

		public Node addChild(String name) {
			Node child = new Node(name);
			children.add(child);
			return this;
		}
	}

	public static void main(String args []) {
			int [] array = {1, 2, 3, 4, -2, 3, 7, 8, -26};
			boolean b = hasSingleCycle(array);
			System.out.println(b);
			
	}
	
	 public static boolean hasSingleCycle(int[] array) {
		    int size = array.length;
		    boolean [] visited = new boolean[size];
		    int index = 0;
		    for(int i = 0 ; i< array.length; i++) {
		      if(visited[index] == false) {
		        visited[index] = true;
		        index = getIndex(index, size, array[index]);
		      }
		      else{
		        return false;
		      }
		    }
		    
		    for(Boolean b : visited) {
		      if(!b) {
		        return false;
		      }
		    }
		    return true && index%size ==0;
		  }
		  private static int getIndex(int current, int size, int jump) {
		    if(current + jump > 0 &&  current + jump < size) {
		      return current+jump;
		    }
		    if(current+jump < 0) {
		      return size  + (current+(jump%size)); 
		    }
		    if(current+jump > size-1) {
		      return ((current+jump) % (size));
		    }
		    return 0;
		  }

}
