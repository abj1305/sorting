package com.practice.dsa.dp;

import java.util.HashMap;
import java.util.Map;

public class MinCostPath {
	
	public static void main(String args[]) {
		
	}
	
	public int cost(int [][] matrix, int i, int j) {
		int n = matrix.length;
		int m = matrix[0].length;
		
		if(i == n-1 && j == m-1) {
			return matrix[i][j];
		}
		else if(i == n-1) {
			return matrix[i][j] + cost(matrix, i, j+1);
		}
		else if(j == m-1) {
			return matrix[i][j] + cost(matrix, i+1, j);
		}
		else {
			return matrix[i][j] + Math.min(cost(matrix, i, j+1), cost(matrix, i+1, j));
		}
	}
	
	// memoization - topdown
	Map<Integer[], Integer> lookup = new HashMap<Integer[], Integer>();
	public int cost1(int [][] matrix, int i, int j) {
		int n = matrix.length;
		int m = matrix[0].length;
		Integer [] key = new Integer [] {i, j};
		Integer val = 0;
		if(lookup.containsKey(key)) {
			return lookup.get(key);
		}
		if(i == n-1 && j == m-1) {
			val = matrix[i][j];
		}
		else if(i == n-1) {
			val = matrix[i][j] + cost1(matrix, i, j+1);
		}
		else if(j == m-1) {
			val = matrix[i][j] + cost1(matrix, i+1, j);
		}
		else {
			val = matrix[i][j] + Math.min(cost1(matrix, i, j+1), cost1(matrix, i+1, j));
		}
		lookup.put(key, val);
		return val;
		
	}
	
	//tabulation - bottomup
	public int cost2(int [][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int [][] dp = new int [n][m];
		dp[0][0] = matrix[0][0];
		for(int x = 1 ; x < n ; x ++) {
			dp[x][0] = matrix[x][0] + dp[x-1][0];
		}
		for(int x = 0; x < m ; x ++) {
			dp[0][x] = matrix[0][x] + dp[0][x-1];
		}
		for(int i = 1; i < n ; i++) {
			for(int j = 1 ; j < m ; j++) {
				dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
			}
		}
		return dp[n-1][m-1];
	}

}
