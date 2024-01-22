package com.practice.leetcode.top75;

public class LL_DeleteMiddle {

	public static void main(String args[]) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(3);
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(7);
		head.next.next.next.next = new ListNode(5);
		LL_DeleteMiddle d = new LL_DeleteMiddle();
		d.deleteMiddle(head);
	}
	
    public ListNode deleteMiddle(ListNode head) {
        int size = 0;
        ListNode tmp = head;
        while(tmp != null) {
        	tmp = tmp.next;
        	size++;
        }
        if(size == 1) {
        	return null;
        }
        int tbd = size/2;
        tmp = head;
        ListNode prev = null;
        int counter = 0;
        while(counter < tbd) {
        	prev = tmp;
        	tmp = tmp.next;
        	counter++;
        }
        prev.next = tmp.next;
        return head;
    }
	
}
