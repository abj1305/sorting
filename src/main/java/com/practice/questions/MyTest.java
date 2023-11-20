package com.practice.questions;

import java.util.Arrays;

public class MyTest {
    public static void main(String[] args) {
        int [] arr = new int []{0,1,0,1,1,1, 0,0,1,1,0,0,0};
        int left = 0;
        int right = arr.length - 1;

        while(left < right ) {
        	while (arr[left] == 0 && left < right) {
        		left ++;
        	}
        	while(arr[right] == 1 && left < right) {
        		right --;
        	}
        	if(arr[left] > arr[right]) {
        		int tmp = arr[left];
        		arr[left] = arr[right];
        		arr[right] = tmp;
        		left ++;
        		right --;
        	}
        }
        System.out.println(Arrays.toString(arr));
    }
}
