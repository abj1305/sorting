package com.practice.questions;

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

//https://www.geeksforgeeks.org/problems/print-adjacency-list-1587115620/1?page=1&category=Graph&difficulty=Easy&sortBy=submissions

class GFG {
  public static void main(String args[]) throws IOException {
      int edges [][] = {
    		  {1,0,1},
    		  {1,1,1},
    		  {0,1,0}
      } ;
      
      Solution s = new Solution();
      
      s.printGraph(3, edges);
      
  }
}

//} Driver Code Ends


//User function Template for Java
class Solution {
  public List<List<Integer>> printGraph(int V, int edges[][]) {
      
      List<List<Integer>> returnList = new ArrayList<List<Integer>>();
      
      for(int i=0;i<edges.length;i++) {
          List<Integer> list = new ArrayList<Integer>();
          returnList.add(i, list);
          for(int j = 0 ; j<edges[i].length;j++) {
              if(edges[i][j] == 1) {
                  returnList.get(i).add(j);
              }
          }
      }
      
      return returnList;
  }
}