package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ArrayTo2DArray {

	public static void main(String[] args) {
		ArrayTo2DArray a = new ArrayTo2DArray();
		a.findMatrix(new int [] {1,3,4,1,2,3,1});

	}
	
    public List<List<Integer>> findMatrix(int[] nums) {
        
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	boolean skip = false;
    	for(int i : nums) {
    		skip = false;
    		for(int j = 0 ; j < list.size();j++) {
    			if(!skip && ! list.get(j).contains(i)) {
    				list.get(j).add(i);
    				skip = true;
    				continue;
    			}
    		}
    		if(skip) continue;
    		addNumberAndList(list, i);
    	}
    	return list;
    	
    }
    
    private void addNumberAndList(List<List<Integer>> list, int num) {
    	List<Integer> innerList = new ArrayList<Integer>();
    	innerList.add(num);
    	list.add(innerList);
    }

}
