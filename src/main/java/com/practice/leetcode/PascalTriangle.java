package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle/
public class PascalTriangle {

	public static void main(String[] args) {
		PascalTriangle pt = new PascalTriangle();
		pt.generate(5);

	}

	public List<List<Integer>> generate(int numRows) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		ans.add(0, list);
		int rowNo = 1;
		while(rowNo < numRows) {
			list = new ArrayList<Integer>();
			List<Integer> prevList = ans.get(rowNo-1);
			for(int i = 0;i <= rowNo; i++) {
				if(i == 0) {
					list.add(i, prevList.get(0));
				}
				else if(i == rowNo) {
					list.add(i, prevList.get(i-1));
				}
				else {
					list.add(i, prevList.get(i-1)+prevList.get(i));
				}
			}
			ans.add(rowNo, list);
			rowNo++;
		}
		return ans;
	}

}
