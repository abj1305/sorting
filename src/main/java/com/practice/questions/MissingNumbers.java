package com.practice.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingNumbers {

	public static void main(String[] args) {
		
		MissingNumbers m = new MissingNumbers();
		m.missingNumbers(new int [] {1,2,3,4,5});
	}


	public int[] missingNumbers(int[] nums) {
		
		int expSum = ((nums.length+2) * (nums.length + 3))/2;
		int actualSum = Arrays.stream(nums).sum();
		float avg = (float)(expSum - actualSum)/2;
		int small = (int)avg;
		List<Integer> list = new ArrayList<Integer>();
		Arrays.stream(nums).forEach(list::add);
		while(small > 0) {
			if(list.contains(small)) {
				small --;
			}
			else {
				break;
			}
		}
		return new int [] {small, expSum-(actualSum+small)};
	}

}
