package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle-ii/
public class PascalTriangle2 {

	
	public static void main(String[] args) {

	}
	
    public List<Integer> getRow(int rowIndex) {
        
    	List<Integer> ans = new ArrayList<Integer>();
    	ans.add(1);
    	long prev = 1;
    	
    	for (int k = 1; k <= rowIndex; k++) {
            long next_val = prev * (rowIndex - k + 1) / k;
            ans.add((int) next_val);
            prev = next_val;
        }
    	
    	return ans;
    }

}
