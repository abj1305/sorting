package com.practice.leetcode;

import java.util.Stack;

public class EasyBracket {

	public static void main(String[] args) {
		EasyBracket b = new EasyBracket();
		System.out.println(
				b.isValid("(())(())(")
				);

	}
	
	//https://leetcode.com/problems/valid-parentheses/description/
	public boolean isValid(String s) {
		Stack <Character> stack = new Stack <Character>();
		for(Character c : s.toCharArray()) {
			if(c.equals('(')) stack.push(')');
			else if(c.equals('[')) stack.push(']'); 
			else if(c.equals('{')) stack.push('}');
			else {
				if(stack.isEmpty() || ! c.equals(stack.pop())) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

}
