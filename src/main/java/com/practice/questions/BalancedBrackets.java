package com.practice.questions;

import java.util.Stack;

public class BalancedBrackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean balancedBrackets(String str) {
		Stack<Character> stack = new Stack<Character>();
		for(char c : str.toCharArray()) {
			if(! isValid(c)) {
				continue;
			}
			if(c == '(') stack.push(')');
			else if(c == '[') stack.push(']');
			else if(c == '{') stack.push('}');
			else {
				if(stack.isEmpty() || ! stack.pop().equals(c)) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	private static boolean isValid(char c) {
		return "(){}[]".indexOf(c) != -1; 
	}
	
}
