package com.practice.leetcode.top75;

public class DP2_UniquePaths {

	public static void main(String args[]) {
		DP2_UniquePaths u = new DP2_UniquePaths();
		int i = u.uniquePaths(3, 4);
		System.out.println(i);
	}
	
	// bottomup-tabulation
    public int uniquePaths(int m, int n) {
        int arr [][] = new int [m][n];
        for(int i=0;i<m;i++)
        	arr[i][0] = 1;
        for(int i=0;i<n;i++)
        	arr[0][i] = 1;
        
        for(int i=1;i <m;i++) {
        	for(int j=1;j < n; j++) {
        		arr[i][j] = arr[i-1][j] + arr[i][j-1];
        	}
        }
        return arr[m-1][n-1];
    }
	
}
