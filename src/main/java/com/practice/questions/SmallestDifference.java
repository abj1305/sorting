package com.practice.questions;

import java.util.Arrays;

public class SmallestDifference {

	public static void main(String[] args) {
		int [] i = smallestDifference(new int [] {-1,5,10,20,28,3}, new int [] {26,134,135,15,17});
		System.out.println(Arrays.toString(i));

	}

	public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		
		int min = Integer.MAX_VALUE;
		int a = 0, b = 0;
		
		for(int i = 0, j=0; i < arrayOne.length && j < arrayTwo.length ; ) {
			int diff = Math.abs(arrayOne[i] - arrayTwo[j]);
			if(diff<min) {
				min = diff;
				a = i;
				b = j;
			}
			if(arrayOne[i] > arrayTwo[j]) {
				j++;
			}
			else {
				i++;
			}
		}
		
		return new int[] {arrayOne[a],arrayTwo[b]};
	}

}
