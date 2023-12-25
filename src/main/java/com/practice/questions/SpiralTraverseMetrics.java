package com.practice.questions;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverseMetrics {

	public static void main(String[] args) {
		int array [][] = {	
				{1, 2, 3, 4},
				{10, 11, 12, 5},
				{9, 8, 7, 6}
		};
		List<Integer> list = spiralTraverse(array);
		System.out.println(list);
	}

	public static List<Integer> spiralTraverse(int[][] array) {
		List<Integer> list = new ArrayList<Integer>();
		
		int sr = 0;
		int sc = 0;
		int er = array.length-1;
		int ec = array[0].length-1;
		
		while(sr<=er && sc<=ec) {
			for(int i = sc; i <= ec && sr<=er && sc<=ec ; i++) {
				list.add(array[sr][i]);
			}
			sr++;
			for(int i = sr ; i <= er && sr<=er && sc<=ec ; i++) {
				list.add(array[i][ec]);
			}
			ec--;
			for(int i = ec ; i>=sc && sr<=er && sc<=ec ; i --) {
				list.add(array[er][i]);
			}
			er--;
			for(int i = er ; i >= sr && sr<=er && sc<=ec ; i--) {
				list.add(array[i][sc]);
			}
			sc++;
		}
		return list;
	}

}
