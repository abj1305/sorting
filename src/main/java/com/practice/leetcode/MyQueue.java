package com.practice.leetcode;

import java.util.Stack;

public class MyQueue {

	Stack<Integer> s1 = null;
	Stack<Integer> s2 = null;
	
    public MyQueue() {
    	s1 = new Stack<Integer>();
    	s2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
    	int val;
        while(! s1.isEmpty()) {
        	s2.push(s1.pop());
        }
        val = s2.pop();
        while(! s2.isEmpty()) {
        	s1.push(s2.pop());
        }
        return val;
    }
    
    public int peek() {
    	int val;
        while(! s1.isEmpty()) {
        	s2.push(s1.pop());
        }
        val = s2.peek();
        while(! s2.isEmpty()) {
        	s1.push(s2.pop());
        }
        return val;
    }
    
    public boolean empty() {
        return s1.empty();
    }
}
