package com.practice.questions;

import java.util.Arrays;

class MinimumWaitingTime {

    public static void main(String[] args) {
        int [] array = {3,2,1,2,6};
        System.out.println();
        
    }

    public static int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int sum = 0;
        for (int i = 0; i < queries.length - 1; i++) {
            sum = sum + (queries[i] * (queries.length - (i + 1)));
        }
        return sum;
    }
}
