package com.practice.sorting.utils;

import java.util.Arrays;

public class ArrayUtils {

    public static int [] getIntegerArray(int size) {
        int [] array = new int [size];
        for(int i = 0 ; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000) ;
        }
        return array;
    }

    public static void printBeforeSort(String type, int [] array) {
        System.out.println("------------------------------------------------");
        System.out.println("Before "+type+" Sort: ");
        System.out.println(Arrays.toString(array));
        System.out.println("------------------------------------------------");
    }

    public static void printAfterSort(String type, int [] array) {
        System.out.println("------------------------------------------------");
        System.out.println("After "+type+" Sort: ");
        System.out.println(Arrays.toString(array));
        System.out.println("------------------------------------------------");
    }
    
}
