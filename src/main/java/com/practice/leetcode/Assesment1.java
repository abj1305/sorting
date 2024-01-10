package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Assesment1 {

	public static void main(String args []) {
		Assesment1 a = new Assesment1();
		a.partitionLabels("caedbdedda");
	}

	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		int x1 = rec1[0];
		int y1 = rec1[1];
		int x2 = rec1[2];
		int y2 = rec1[3];

		int a1 = rec2[0];
		int b1 = rec2[1];
		int a2 = rec2[2];
		int b2 = rec2[3];

		boolean xOverlap = ((x1 < a1 && x2 > a1) || (x1 < a2 && x2 > a2)) || ((a1<x1 && a2>x1) || (a1 < x2 && a2 > x2));
		boolean yOverlap = ((y1 < b1 && y2 > b1) || (y1 < b2 && y2 > b2)) || ((b1<y1 && b2>y1) || (b1 < y2 && b2 > y2));

		return xOverlap && yOverlap;

	}

	public List<Integer> partitionLabels(String s) {
		List<Integer> ans = new ArrayList<Integer>();

		int old=0;
		int maxTillNow = 0;
		for(int i = 0;i < s.length(); i++) {
			char c = s.charAt(i);
			maxTillNow = s.lastIndexOf(c);
			int j = i+1;
			while(j <= maxTillNow && i < s.length()) {
				c = s.charAt(j);
				if(s.lastIndexOf(c) > maxTillNow) {
					maxTillNow = s.lastIndexOf(c);
				}
				j++;
				i++;
			}
			if(old == 0) {
				ans.add(maxTillNow-old+1);
			}
			else {
				ans.add(maxTillNow-old);
			}
			
			old = maxTillNow;
		}
		return ans;
		
	}

}
