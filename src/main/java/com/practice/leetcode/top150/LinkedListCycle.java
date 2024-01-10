package com.practice.leetcode.top150;



class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}


public class LinkedListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean hasCycle(ListNode head) {
		
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && slow != null) {
			slow = slow.next;
			if(fast.next != null) {
				fast = fast.next.next;
				if(slow == fast) {
					return true;
				}
			}
		}
		return false;
	}

}
