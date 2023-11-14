package com.practice.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Program {

    public static void main(String[] args) {
        ArrayList<Integer> redShirtHeights =
      new ArrayList<Integer>(Arrays.asList(5, 8, 1, 3, 4, 9));
    ArrayList<Integer> blueShirtHeights =
      new ArrayList<Integer>(Arrays.asList(6, 9, 2, 4, 5, 1));
        System.out.println(classPhotos(redShirtHeights, blueShirtHeights));
        
    }

    public static int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int sum = 0;
        for (int i = 0; i < queries.length - 1; i++) {
            sum = sum + (queries[i] * (queries.length - (i + 1)));
        }
        return sum;
    }

    public static boolean  classPhotos( ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(blueShirtHeights);
        Collections.sort(redShirtHeights);

        if(blueShirtHeights.get(0) < redShirtHeights.get(0)) {
            for(int i = 0; i<blueShirtHeights.size();i++) {
                if(blueShirtHeights.get(i) >= redShirtHeights.get(i)) {
                    return false;
                }
            }
        }
        else{
            for(int i = 0; i<blueShirtHeights.size();i++) {
                if(redShirtHeights.get(i) >= blueShirtHeights.get(i)) {
                    return false;
                }
            }
        }

        return true;
    }
}
