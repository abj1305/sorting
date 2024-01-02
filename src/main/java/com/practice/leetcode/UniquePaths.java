package com.practice.leetcode;

public class UniquePaths {

	public static void main(String args []) {
		UniquePaths s = new UniquePaths();
		s.uniquePaths(8, 4);
	}

	public int uniquePaths(int m, int n) {
		int dp [][] = new int [m][n];
		for(int row = 0; row < m ;row++) {
			dp[row][0] = 1;
		}
		for(int col = 0; col < n ;col++) {
			dp[0][col] = 1;
		}
		
		for(int r = 1; r < m; r++) {
			for(int c = 1;c<n;c++) {
				dp[r][c] = dp[r-1][c] + dp[r][c-1];
			}
		}
		return dp [m-1][n-1];
	}


}
