package com.practice.sorting.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.sorting.aop.ExecutionTimeLogger;
import com.practice.sorting.service.SortingService;
import com.practice.sorting.utils.ArrayUtils;

@RestController
public class SortingController {

    @Autowired
    private SortingService sortingService;
    
    @RequestMapping("/testApi")
    public String testApi() {
        System.out.println("I was here");
        return "API is Running";
    }

    @ExecutionTimeLogger
    @RequestMapping("/bubbleSort")
    public int [] bubbleSort() {
        int [] array = ArrayUtils.getIntegerArray(100);
        ArrayUtils.printBeforeSort("Bubble", array);
        array =  sortingService.bubbleSort(array);
        ArrayUtils.printAfterSort("Bubble", array);
        return array;
    }

    @ExecutionTimeLogger
    @RequestMapping("/selectionSort")
    public int [] selectionSort() {
        int [] array = ArrayUtils.getIntegerArray(100);
        ArrayUtils.printBeforeSort("Selection", array);
        array =  sortingService.selectionSort(array);
        ArrayUtils.printAfterSort("Selection", array);
        return array;
    }

    @ExecutionTimeLogger
    @RequestMapping("/insertionSort")
    public int [] insertionSort() {
        int [] array = ArrayUtils.getIntegerArray(100);
        ArrayUtils.printBeforeSort("Insertion", array);
        array =  sortingService.insertionSort(array);
        ArrayUtils.printAfterSort("Insertion", array);
        return array;
    }

    @ExecutionTimeLogger
    @RequestMapping("/mergeSort")
    public int [] mergeSort() {
        int [] array = ArrayUtils.getIntegerArray(100);
        ArrayUtils.printBeforeSort("Merge", array);
        array =  sortingService.mergeSort(array, 0, array.length-1);
        ArrayUtils.printAfterSort("Merge", array);
        return array;
    }
    
}
