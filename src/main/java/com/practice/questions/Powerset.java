package com.practice.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Powerset {

	public static void main(String[] args) {


	}


	public static List<List<Integer>> powerset(List<Integer> array) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		return list;
	}
	
	
	public boolean isAnagram(String s, String t) {
        char [] sa = s.toCharArray();
        char [] ta = t.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(ta);

        return Arrays.equals(sa, ta);       
    }
}
