package com.practice.leetcode;

import java.util.Stack;

public class ReversePolishNotation {

	public static void main(String args []) {
		ReversePolishNotation r = new ReversePolishNotation();
		int i = r.evalRPN(new String[] {"4","13","5","/","+"});
		System.out.println(i);
	}

	//	long resolves(long a, long b, char Operator) {
	//        if (Operator == '+') return a + b;
	//        else if (Operator == '-') return a - b;
	//        else if (Operator == '*') return a * b;
	//        return a / b;
	//    }
	//
	//    public int evalRPN(String[] tokens) {
	//        Stack<Long> stack = new Stack<>();
	//        int n = tokens.length;
	//        for (int i = 0; i < n; i++) {
	//            if (tokens[i].length() == 1 && tokens[i].charAt(0) < 48) {
	//                long integer2 = stack.pop();
	//                long integer1 = stack.pop();
	//                char operator = tokens[i].charAt(0);
	//                long resolvedAns = resolves(integer1, integer2, operator);
	//                stack.push(resolvedAns);
	//            } else {
	//                stack.push(Long.parseLong(tokens[i]));
	//            }
	//        }
	//        return stack.pop().intValue();
	//    }

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0 ; i < tokens.length; i++) {
			String cur = tokens[i];
			if("+".equals(cur) || "-".equals(cur) || "*".equals(cur) || "/".equals(cur)) {
				int b = stack.pop();
				int a = stack.pop();
				stack.add(solve(a, b, cur));
			}
			else {
				stack.push(Integer.valueOf(cur));
			}
		}
		return stack.pop();
	}
	private Integer solve(Integer a, Integer b, String operator) {
		switch(operator) {
		case "+" :
			return a+b;
		case "-" :
			return a-b;
		case "*" :
			return a*b;
		case "/" :
			return a/b;
		default:
			return 0;
		}
	}

}
