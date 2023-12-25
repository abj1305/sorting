package com.practice.questions;

import java.util.ArrayList;
import java.util.List;


//https://www.algoexpert.io/questions/move-element-to-end
public class MoveElementToEnd {

	public static void main(String[] args) {

		int [] a = {2,1,2,2,2,3,4,2};
		List<Integer> la = new ArrayList<Integer>();
		for(int i : a) {
			la.add(i);
		}
		List <Integer>l  = moveElementToEnd(la, 2);
		System.out.println(l);


	}

	public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
		int i = 0;
		int j = array.size()-1;
		while(i < j) {
			while(array.get(j) == toMove && i < j) {
				j--;
			}
			while(array.get(i) != toMove && i < j) {
				i++;
			}
			int temp = array.get(j);
			array.set(j, array.get(i));
			array.set(i, temp);
			i++;j--;
		}
		return array;
	}

}
