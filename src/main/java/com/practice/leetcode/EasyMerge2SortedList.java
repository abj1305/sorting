package com.practice.leetcode;


  //Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 

public class EasyMerge2SortedList {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		EasyMerge2SortedList e = new EasyMerge2SortedList();
		e.mergeTwoLists(l1, l2);

	}
	
	//https://leetcode.com/problems/merge-two-sorted-lists/
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    	if(list1 == null) {
    		return list2;
    	}
    	if(list2 == null) {
    		return list1;
    	}
    	ListNode mergedList = list1.val < list2.val ? list1 : list2;
    	ListNode returnList = mergedList;
    	if(list1.val < list2.val) {
    		list1 = list1.next;
    	}
    	else {
    		list2 = list2.next;
    	}
    	
    	while(list1 != null && list2 !=null) {
    		if(list1.val < list2.val) {
    			mergedList.next = list1;
    			list1 = list1.next;
    		}
    		else {
    			mergedList.next = list2;
    			list2 = list2.next;
    		}
    		mergedList = mergedList.next;
    	}
    	if(list1 != null) {
    		mergedList.next = list1;
    	}
    	else if(list2 != null) {
    		mergedList.next = list2;
    	}
    	
    	return returnList;
    	
    }

}
