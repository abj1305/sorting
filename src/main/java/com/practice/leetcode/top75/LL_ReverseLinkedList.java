package com.practice.leetcode.top75;

import java.util.Stack;

public class LL_ReverseLinkedList {

	public static void main(String args[]) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		LL_ReverseLinkedList d = new LL_ReverseLinkedList();
		d.reverseList(head);
	}

	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode prev = head;
		ListNode cur = head.next;
		ListNode tmp = null;
		boolean first = true;
		while(cur != null) {
			tmp = cur.next;
			if(first) {
				prev.next = null;
				first = false;
			}
			cur.next = prev;
			prev = cur;
			cur = tmp;
		}

		return prev;
	}

	public ListNode reverseList2(ListNode head) {
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode tmp = head;
		while(tmp != null) {
			stack.push(tmp);
			tmp = tmp.next;
		}
		boolean first = true;
		while(!stack.isEmpty()) {
			if(first) {
				head = stack.pop();
				tmp = head;
				first = false;
			}
			else {
				tmp.next = stack.pop();
				tmp = tmp.next;
			}
		}
		if(tmp!=null) tmp.next = null;
		return head;
	}

}
