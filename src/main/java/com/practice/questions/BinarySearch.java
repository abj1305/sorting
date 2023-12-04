package com.practice.questions;

public class BinarySearch {

	public static void main(String[] args) {
		int [] array = {11,22,31,41,54,62,76,80,97};
		int element = 11;
		
		boolean present = binarySearch(array, element, 0, array.length-1);
		System.out.println(present);

	}
	
	public static boolean binarySearch(int [] array, int element, int start, int end) {
		
		int mid = (start+end)/2; //start/2 + end/2
		//int mid2 = start + (end-start)/2; //start + end/2 - start/2
		
		if(element < array[start] || element > array[end]) {
			return false;
		}
		if(element == array[mid]) {
			return true;
		}
		
		if(element < array[mid]) {
			return binarySearch(array, element, start, mid-1);
		}
		else {
			return binarySearch(array, element, mid+1, end);
		}
	}
}
