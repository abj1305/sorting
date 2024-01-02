package com.practice.leetcode;

// https://leetcode.com/problems/spiral-matrix-ii/
public class SpiralMatrix2 {

	public static void main(String[] args) {
		SpiralMatrix2 s = new SpiralMatrix2();
		int[][] m = s.generateMatrix(3);
		System.out.println(m);
	}

	public int[][] generateMatrix(int n) {
		int [][] matrix = new int [n][n];
		int rs = 0;
		int cs = 0;
		int re = n-1;
		int ce = n-1;
		int counter=1;
		
		while(rs <= re && cs <= ce) {
			for(int i = cs;i<=ce && rs <= re;i++) {
				matrix[rs][i] = counter++;
			}
			rs++;
			for(int i = rs; i <= re && cs <= ce; i++) {
				matrix[i][ce] = counter++;
			}
			ce--;
			for(int i = ce; i>=cs && rs <= re; i--) {
				matrix[re][i] = counter++;
			}
			re--;
			for(int i=re;i>=rs && cs <= ce;i--) {
				matrix[i][cs]=counter++;
			}
			cs++;
		}
		return matrix;
	}

}
