package com.practice.questions;

public class MonotonicArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isMonotonic(int[] array) {
		if(array.length == 0 || array.length == 1) {
			return true;
		}
		boolean checkNonDecreasing = false;
		
		for(int i = 1 ; i<array.length;i++) {
			if(array[i] == array[i-1]) {
				continue;
			}
			checkNonDecreasing = array[i] > array[i-1] ? true:false;
			break;
		}
		
		if(checkNonDecreasing) {
			for(int i=1;i<array.length;i++) {
				if(array[i-1] > array[i]) {
					return false;
				}
			}
		}
		else {
			for(int i=1;i<array.length;i++) {
				if(array[i] > array[i-1]) {
					return false;
				}
			}
		}
		return true;
	}

}
