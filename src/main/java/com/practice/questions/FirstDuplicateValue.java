package com.practice.questions;

public class FirstDuplicateValue {

	public static void main(String[] args) {
		FirstDuplicateValue e = new FirstDuplicateValue();
		int i = e.firstDuplicateValue(new int [] {3, 1, 3, 1, 1, 4, 4});
		System.out.println(i);

	}

	//https://www.algoexpert.io/questions/first-duplicate-value
	public int firstDuplicateValue(int[] array) {
		
		for(int i : array) {
			int index = Math.abs(i)-1;
			if(array[index] < 0) {
				return index + 1;
			}
			else {
				array [index] = array[index] * -1; 
			}
		}
		return -1;
	}

}
