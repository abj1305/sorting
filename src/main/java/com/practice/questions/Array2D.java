package com.practice.questions;

public class Array2D {

	public static void main(String[] args) {
		
		int [][] array = {
				{11,12,13,14},
				{21,22,23,24},
				{31,32,33,34},
				{41,42,43,44},
				{51,52,53,54}
		};
		
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}

	}

}
