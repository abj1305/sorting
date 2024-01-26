package com.practice.educative99;

public class RemoveNthElementFromEnd {

	public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
		LinkedListNode left = head;
		LinkedListNode right = head;
		for(int i = 0 ; i < n ; i++) {
			right = right.next;
		}
		if(right == null) {
			return head.next;
		}
		while(right.next!=null) {
			left = left.next;
			right = right.next;
		}
		left.next = left.next.next;	
		return head;
	}
}
