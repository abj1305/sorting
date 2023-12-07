package com.practice.dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyArrayToList {

	public static void main(String[] args) {
		int [][] array = {
				{0,1,1,0,1},
				{1,1,0,0,0},
				{0,0,1,0,1},
				{1,0,0,0,0},
				{0,1,1,0,0}
		};
		
		printGraph(5, array);

	}
	
	public static List<List<Integer>> printGraph(int V, int edges[][]) {
	    
	    List<List<Integer>> returnList = new ArrayList<List<Integer>>();
	      
	      for(int i=0;i<edges.length;i++) {
	          List<Integer> list = new ArrayList<Integer>();
	          for(int j = 0 ; j<edges[i].length;j++) {
	              if(edges[i][j] == 1) {
	                  list.add(j);
	              }
	          }
	          returnList.add(i, list);
	      }
	      return returnList;    
	    
	    }

}
