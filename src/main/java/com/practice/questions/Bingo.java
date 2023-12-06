package com.practice.questions;

public class Bingo {

	public static void main(String[] args) {
		
		int [] [] mat = {
				{1,6,8},
				{2,4,7},
				{5,3,9}
		};
		
		int [] array = {1,2,6,4,9,8}; 
		
		System.out.println(getBingoNumber(mat, array));

	}
	
	public static int getBingoNumber(int [][] mat, int arr[]) {
		
		for(Integer number : arr) {
			markNumber(mat, mat.length, mat[0].length, number);
			if(isBingo(mat, mat.length, mat[0].length)) {
				return number;
			}
		}
		return 0;
		
	}
	
	public static void markNumber (int [][] mat,int x, int y, int number) {
		for(int i=0; i<x;i++) {
			for(int j = 0; j< y;j++) {
				if(mat[i][j] == number) {
					mat[i][j] = -1;
					return;
				}
			}
		}
	}
	
	public static boolean isBingo(int [][] mat,int x, int y) {

		boolean complete = false;
		for(int i=0;i<x;i++) {
			int size=0;
			for(int j=0;j<y;j++) {
				if(mat[i][j] != -1) {
					continue;
				}
				else {
					size++;
				}
				if(size == x) {
					complete=true;
				}
			}
		}
		
		if(complete) return true;
		
		for(int i=0;i<y;i++) {
			int size=0;
			for(int j=0;j<x;j++) {
				if(mat[j][i] != -1) {
					continue;
				}
				else {
					size++;
				}
				if(size == x) {
					complete=true;
				}
			}
		}
		if(complete) return true;
		
		return false;
		
	}

}
