package com.practice.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Semordnilap {

	public static void main(String[] args) {
		Semordnilap s = new Semordnilap();
		

	}

	public ArrayList<ArrayList<String>> semordnilap(String[] words) {
		Map<char[], ArrayList<String>> map = new HashMap<char[], ArrayList<String>>();
		for(String word : words) {
			char [] arr = word.toCharArray();
			Arrays.sort(arr);
			if(map.containsKey(arr)) {
				map.get(arr).add(word);
			}
			else {
				ArrayList <String> list = new ArrayList<String>();
				list.add(word);
				map.put(arr, list);
			}
		}
		ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
		for(char[] key : map.keySet()) {
			ans.add(map.get(key));
		}
		return ans;
	}

}
