package com.practice.questions;

public class Transpose2DArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] transposeMatrix(int[][] matrix) {

		int returnArray [][]= new int [matrix[0].length] [matrix.length];

		for(int i = 0 ;i < matrix.length;i++) {
			for(int j = 0 ; j< matrix[0].length;j++) {
				returnArray[j][i] = matrix[i][j];
			}
		}

		return returnArray;
	}

}
