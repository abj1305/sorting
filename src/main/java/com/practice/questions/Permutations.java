package com.practice.questions;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(2);
		input.add(3);
		List<List<Integer>> list = getPermutations(input);
		System.out.println(list.toString());
	}

	public static List<List<Integer>> getPermutations(List<Integer> array) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
 		if(array.size() == 0) {
 			return list;
 		}
 		helper(list, new ArrayList<Integer>(), array);	
		return list;
	}
	
	public static void helper(List<List<Integer>> list, List<Integer> fixed, List<Integer> variable) {
		if(variable.size() == 0) {
			list.add(new ArrayList<Integer>(fixed));
			return;
		}
		else {
			List<Integer> tmp = new ArrayList<>(variable);
			for(Integer i : variable) {
				fixed.add(i);
				tmp.remove(i);
				helper(list, fixed, tmp);
				fixed.remove(i);
				tmp.add(i);
			}
		}
	}
	
	

}
