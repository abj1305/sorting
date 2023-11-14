package com.practice.sorting.service;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SortingServiceTest {


    @InjectMocks
    private SortingService sortingService;
    

    @Test
    public void bubbleSort() {
        int [] inputArray = getRandomArray();
        int [] array = sortingService.bubbleSort(inputArray);

        for(int i = 0; i<array.length - 1;i++) {
            if(array[i] > array[i+1]) {
                fail();
            }
        }
    }

    @Test
    public void selectionSort() {
        int [] inputArray = getRandomArray();
        int [] array = sortingService.selectionSort(inputArray);

        for(int i = 0; i<array.length - 1;i++) {
            if(array[i] > array[i+1]) {
                fail();
            }
        }
    }

    @Test
    public void insertionSort() {
        int [] inputArray = getRandomArray();
        int [] array = sortingService.bubbleSort(inputArray);

        for(int i = 0; i<array.length - 1;i++) {
            if(array[i] > array[i+1]) {
                fail();
            }
        }
    }

    @Test
    public void mergeSort() {
        int [] inputArray = getRandomArray();
        int [] array = sortingService.mergeSort(inputArray, 0, inputArray.length-1);

        for(int i = 0; i<array.length - 1;i++) {
            if(array[i] > array[i+1]) {
                fail();
            }
        }
    }

    private int[] getRandomArray() {
        int size = (int) (Math.random() * 100);
        int [] array = new int[size];
        for(int i = 0 ; i < size ; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }
}
