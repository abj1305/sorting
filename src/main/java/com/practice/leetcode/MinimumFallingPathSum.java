package com.practice.leetcode;

public class MinimumFallingPathSum {

	public static void main(String args[]) {
		MinimumFallingPathSum m = new MinimumFallingPathSum();
		int [][] matrix = {
				{-19,57},
				{-40,-5}
		};
		m.minFallingPathSum(matrix);
	}

	public int minFallingPathSum(int[][] matrix) {
		int [][] dp = new int [matrix.length][matrix[0].length];
		for(int i = 0 ; i < matrix[0].length ; i++) {
			dp[0][i] = matrix[0][i];
		}
		for(int i = 1 ; i < matrix[0].length ; i++) {
			for(int j = 0 ; j < matrix[0].length ; j++) {
				if(j==0) {
					dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
				}
				else if(j == matrix[0].length-1) {
					dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
				}
				else {
					dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i-1][j+1]));
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0 ; i < matrix[0].length ; i++) {
			min = Math.min(min, dp[matrix.length-1][i]);
		}
		return min;
	}

}
