package com.practice.leetcode.top150;



public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNodee addTwoNumbers(ListNodee l1, ListNodee l2) {
		ListNodee returnList = null;
		ListNodee ans = null;
		int carry = 0;
		boolean first = true;
		while(l1!= null && l2!=null){
			if(first){
				returnList = new ListNodee();
				ans = returnList;
				first = false;
			}else{
				returnList.next = new ListNodee();
				returnList = returnList.next;
			}

			int newVal = (l1.val + l2.val + carry) %10;
			carry = (l1.val + l2.val + carry) / 10;
			returnList.val = newVal;
			returnList.next = null;
			l1 = l1.next;
			l2 = l2.next;
		}
		if(l1 == null) {
			while(l2!=null) {
				returnList.next = new ListNodee();
				returnList = returnList.next;
				int newVal = (l2.val + carry) %10;
				carry = (l2.val + carry) / 10;
				returnList.val = newVal;
				returnList.next = null;
				l2 = l2.next;
			}
		}
		if(l2==null) {
			while(l1!=null) {
				returnList.next = new ListNodee();
				returnList = returnList.next;
				int newVal = (l1.val + carry) %10;
				carry = (l1.val + carry) / 10;
				returnList.val = newVal;
				returnList.next = null;
				l1 = l1.next;
			}
		}
		if(carry != 0){
			returnList.next = new ListNodee(carry);
		}
		return ans;  

	}
}
