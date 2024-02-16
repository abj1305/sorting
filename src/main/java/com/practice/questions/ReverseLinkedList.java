package com.practice.questions;

public class ReverseLinkedList {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList(1);
		ll.next = new LinkedList(2);
		ll.next.next = new LinkedList(3);
		ll.next.next.next = new LinkedList(4);
		LinkedList head = reverseLinkedList(ll);
		System.out.println(head);

	}

	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}
	
	public static LinkedList reverseLinkedList(LinkedList head) {
		LinkedList prev = null;
		LinkedList tmp = head.next;
		while(tmp != null) {
			tmp = head.next;
			head.next = prev;
			prev = head;
			head = tmp;
		}
		return prev != null ? prev : head;
	}

}
