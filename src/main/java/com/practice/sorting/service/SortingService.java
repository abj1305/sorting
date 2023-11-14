package com.practice.sorting.service;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class SortingService {
    
    public int [] bubbleSort(int [] array) {
        for(int i=0;i<array.length;i++) {
            for(int j=0;j<(array.length-i-1);j++){
                if(array[j] > array[j+1]) {
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;
    }

    /**
     * Bring the max element at the last and so on
     * 
     * @param array
     * @return
     */
    public int [] selectionSort(int [] array) {

        for(int i=0;i<array.length;i++) {
            int max = -100000;
            int maxIndex=0;
            int j;
            for(j=0; j<array.length-i;j++) {
                if(array[j]>max) {
                    maxIndex = j;
                    max = array[j];
                }
            }
            int tmp = array[j-1];
            array[j-1] = array[maxIndex];
            array[maxIndex] = tmp;


        }

        return array;
    }

    /**
     * FOr every iteration of the for loop, keep left most part sorted
     * @param array
     * @return int []
     */
    public int [] insertionSort(int [] array) {

        for(int firstUnsortedIndex = 1; firstUnsortedIndex<array.length;firstUnsortedIndex++) {
            int element = array[firstUnsortedIndex];
            for(int i = firstUnsortedIndex-1; i>=0;i--) {
                if(array[i]>element) {
                    int tmp = array[i];
                    array[i] = element;
                    array[i+1] = tmp;
                    
                }
                else{
                    continue;
                }
            }
        }
        return array;

    }

    public int [] mergeSort2(int [] array, int l, int r) {

        if(l<r) {
            int m = (l + (r-1))/2;
            mergeSort2(array, l, m);
            mergeSort2(array, m+1, r);
            merge2(array, l, m, r);
        }

        return array;
    }

    public void merge2(int [] arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        // Merge the temp arrays
 
        // Initial indices of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public int [] mergeSort(int [] array, int l, int r) {
        if(l<r) {
            int m = (l + (r-1))/2;
            mergeSort(array, l, m);
            mergeSort(array, m+1, r);
            merge(array, l, m, r);
        }

        return array;
    }

    public void merge(int [] array, int l, int m , int r) {
        // find size of both the arrays
        int n1 = (m-l)+1;
        int n2 = (r-m);

        // 2 temp arrays
        int [] L = new int[n1];
        int [] R = new int[n2];

        //fill both the arrays
        L = Arrays.copyOfRange(array, l, m+1);
        R = Arrays.copyOfRange(array, m+1, r+1);

        int lcounter=0, rcounter=0;

       while(lcounter<n1 && rcounter<n2){
            if(L[lcounter] > R[rcounter]) {
                array[l++] = R[rcounter++];
            }
            else{
                array[l++] = L[lcounter++];
            }
        }
        if(lcounter == n1) {
            while(rcounter<n2) {
                array[l++] = R[rcounter++];
            }
        }
        else{
            while(lcounter<n1) {
                array[l++] = L[lcounter++];
            }
        }

    }


}
