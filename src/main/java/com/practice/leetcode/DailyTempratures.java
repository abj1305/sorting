package com.practice.leetcode;

import java.util.Stack;

public class DailyTempratures {

	public static void main(String[] args) {
		DailyTempratures d = new DailyTempratures();
		d.dailyTemperatures(new int[] {73,74,75,71,69,72,76,73});
	}
	
//	public int[] dailyTemperatures(int[] temperatures) {
//        int n = temperatures.length;
//        int[] answer = new int[n];
//        Stack<Integer> stack = new Stack<>();
//
//        for (int i = 0; i < n; i++) {
//            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
//                int index = stack.pop();
//                answer[index] = i - index;
//            }
//            stack.push(i);
//        }
//
//        return answer;
//    }
	
	public int[] dailyTemperatures(int[] temperatures) {
		int n = temperatures.length;
		int [] ans = new int [n];
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0 ; i < temperatures.length; i++) {
			while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				int index = stack.pop();
				ans[index] = i - index;
			}
			stack.push(i);
		}
		return ans;
	}
    

}
