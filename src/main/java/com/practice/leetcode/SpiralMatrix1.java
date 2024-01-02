package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix1 {

	public static void main(String[] args) {
		int array [][] = {	
				{1, 2, 3, 4},
				{10, 11, 12, 5},
				{9, 8, 7, 6}
		};
		List<Integer> list = spiralOrder(array);
		System.out.println(list);
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		
		List<Integer> list = new ArrayList<Integer>();
		int rs = 0;
		int cs = 0;
		int re = matrix.length-1;
		int ce = matrix[0].length-1;
		
		while(rs<=re && cs<=ce) {
			for(int i = cs;i<=ce && rs<=re;i++) {
				list.add(matrix[rs][i]);
			}
			rs++;
			for(int i = rs;i<=re && cs<=ce;i++) {
				list.add(matrix[i][ce]);
			}
			ce--;
			for(int i = ce ; i>=cs && rs<=re; i--) {
				list.add(matrix[re][i]);
			}
			re--;
			for(int i = re ; i >=rs && cs<=ce;i--) {
				list.add(matrix[i][cs]);
			}
			cs++;
		}
		return list;
	}

}
