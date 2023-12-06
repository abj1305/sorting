package com.practice.questions;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

	public static void main(String[] args) {
		List<Integer> list = List.of(1,2,3,4,5,6,7,8,9);
		System.out.println(
				reverseArray(new ArrayList<>(list))
				);

	}

	public static List<Integer> reverseArray(List<Integer> a) {
		
		List<Integer> returnList = new ArrayList<Integer>();
		
		for(int i = a.size()-1 ; i>=0;i--) {
			returnList.add(a.get(i));
		}
		
		return returnList;

	}
}
