package com.practice.leetcode.top150;

import java.util.Stack;

public class ValidParenthysis {
	
	public static void main(String args []) {
		
	}
	
    public boolean isValid(String s) {
    	Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()) {
        	if(c == '(') stack.push(')');
        	else if(c == '[') stack.push(']');
        	else if(c == '{') stack.push('}');
        	else {
        		if(stack.isEmpty() || c != stack.pop()) {
        			return false;
        		}
        	}
        }
        return stack.isEmpty();
    }

}
