package com.practice.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

class Node
{
	int data;
	Node next;
	Node left;
	Node right;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}

public class Questions {

	public static void main(String args []) {

		Questions q = new Questions();

		
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(3);
		Node six = new Node(2);
		Node seven = new Node(1);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		six.next = seven;
		boolean condition = q.isPalindrome(one);
		System.out.println("isPalidrome :" + condition);
		
	}
	
	//https://www.geeksforgeeks.org/problems/check-for-bst/1?page=1&category=Binary%20Search%20Tree&sortBy=submissions
	boolean isBST(Node root) {
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		return isInRange(root, min, max);
	}
	
	boolean isInRange(Node node , int min, int max) {
		if(node == null) {
			return true;
		}
		if(! isInRange(node.left, min, node.data -1)) {
			return false;
		}
		if(node.data < min || node.data > max) {
			return false;
		}
		return isInRange(node.right, node.data + 1, max);
	}
	
	//https://www.geeksforgeeks.org/problems/delete-a-node-from-bst/1?page=1&category=Binary%20Search%20Tree&sortBy=submissions
	public static Node deleteNode(Node root, int X) {
        if(root == null) {
            return root;
        }
        if(X < root.data) {
            root.left = deleteNode(root.left, X);
        }
        else if(X > root.data) {
            root.right = deleteNode(root.right, X);
        }
        else{
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else{
                root.data = min(root.right);
                root.right = deleteNode(root.right, root.data);
            }
            
        }
        return root;
    }
    private static int min(Node node) {
	    	if(node.left != null) {
	    		return min(node.left);
	    	}
	    	else {
	    		return node.data;
	    	}
    }
	
	
	//https://www.geeksforgeeks.org/problems/insert-a-node-in-a-bst/1?page=1&category=Binary%20Search%20Tree&sortBy=submissions
    Node insert(Node root, int Key) {
        Node prev = null;
        Node cur = root;
        Node newNode = new Node(Key);
        while(cur != null) {
        	prev = cur;
        	if(cur.data > Key) {
        		cur = cur.left;
        	}
        	else if(cur.data < Key) {
        		cur = cur.right;
        	}
        	else {
        		return root;
        	}
        }
        if(prev == null) {
        	root = newNode;
        }
        if(prev.data > Key) {
        	prev.left = newNode;
        }
        else if(prev.data < Key){
        	prev.right = newNode;
        }
        return root;
    }
	

	// https://www.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1?page=1&category=Linked%20List&difficulty=Medium&sortBy=submissions
	boolean isPalindrome(Node head) 
    {
		Stack<Integer> stack = new Stack<Integer>();
        Node tail = head;
        while(tail != null) {
            stack.push(tail.data);
        	tail = tail.next;
            
        }
        while(head !=null){
        	if(! stack.pop().equals(head.data)) {
        		return false;
        	}
        	else {
        		head = head.next;
        	}
        }
        return true;
    }    
	
	//https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?page=1&category=DFS&sortBy=submissions
	public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean visited [] = new boolean [V];
		for(int i=0;i<V;i++) {
			if(!visited[i]) {
				if(isCyclic(i, -1,adj, visited)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isCyclic(int vertex, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
		visited[vertex] = true;
		for(Integer child : adj.get(vertex)) {
			if(!visited[child]) {
				if (isCyclic(child, vertex, adj, visited)) {
					return true;
				}
			}
			else if(child != parent){
				return true;
			}	
		}
		return false;
	}

	public static String reverseWord(String str)
	{

		return new StringBuilder(str).reverse().toString();
	}

	//https://www.geeksforgeeks.org/problems/find-duplicates-in-an-array/1?page=1&sortBy=submissions
	public static ArrayList<Integer> duplicates(int arr[], int n) {
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			if(set.contains(arr[i])) {
				set2.add(arr[i]);
			}
			else{
				set.add(arr[i]);
			}
		}

		if(set2.isEmpty()) {
			set2.add(-1);
		}
		list.addAll(set2);
		Collections.sort(list);
		return list;
	}

	//https://www.geeksforgeeks.org/problems/missing-number-in-array1416/1?page=1&sortBy=submissions
	int missingNumber(int array[], int n) {

		int requiredSum = (n*(n+1))/2;
		int actualSum = Arrays.stream(array).reduce(0, (x,y) -> x+y);

		return requiredSum - actualSum;

	}

	//https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
	public static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
		int start = 0;
		int end = K;
		long sum = 0;
		for(int j = start;j<end;j++) {
			sum += Arr.get(j);
		}
		long max = sum;
		start ++;
		end++;
		while(end <= N) {
			sum = sum - Arr.get(start-1);
			sum = sum + Arr.get(end-1);
			if(sum > max) {
				max = sum;
			}
			start ++;
			end++;
		}

		return max;
	}

	//https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1?page=1&sortBy=submissions
	public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
	{
		TreeSet<Integer> s1 = new TreeSet<Integer>();
		for(Integer i : arr1) {
			s1.add(i);
		}
		for(Integer i : arr2) {
			s1.add(i);
		}
		return new ArrayList<Integer>(s1);
	}

	//https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1?page=1&sortBy=submissions
	public static ArrayList<Integer> findUnion2(int arr1[], int arr2[], int n, int m)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		while(i<n || j<m) {
			if(i<n && j<m) {
				if(arr1[i] < arr2[j]) {
					if(! list.contains(arr1[i])) {
						list.add(arr1[i++]);
					}
					else {
						i++;
					}

				}
				else if(arr1[i] > arr2[j]) {
					if(! list.contains(arr2[j])) {
						list.add(arr2[j++]);
					}
					else {
						j++;
					}

				}
				else{
					if(! list.contains(arr1[i])) {
						list.add(arr1[i]);
					}
					i++;
					j++;
				}
				if(i==n) {
					while(j<m) {
						if(!list.contains(arr2[j])) {
							list.add(arr2[j++]);
						}
						else{
							j++;
						}

					}
				}
				if(j==m) {
					while(i<n) {
						if(! list.contains(arr1[i])){
							list.add(arr1[i++]);
						}
						else{
							i++;
						}

					}
				}
			}

		}
		return list;
	}

	//Function to find a continuous sub-array which adds up to a given number.
	static ArrayList<Integer> subarraySum2(int[] arr, int n, int s) 
	{
		ArrayList<Integer> returnList = new ArrayList<Integer>();
		returnList.add(-1);
		returnList.add(-1);

		int [] array;
		for(int i=0;i<n;i++) {
			if(arr[i] == s) {
				returnList.set(0,i+1);
				returnList.set(1,i+1);
				return returnList;
			}
			for (int j=i+1;j<=n;j++) {
				array = Arrays.copyOfRange(arr,i,j);
				int sum = Arrays.stream(array).reduce(0, (x,y) -> x+y);
				if(sum == s) {
					returnList.set(0,i+1);
					returnList.set(1,j);
					return returnList;
				}
			}
		}
		returnList.remove(0);
		return returnList;

	}

	//Function to find a continuous sub-array which adds up to a given number.
	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
	{
		int start = 0;
		int last = 0;
		boolean flag=false;
		int currsum=0;
		ArrayList<Integer> res = new ArrayList<Integer>();

		for(int i=0;i<n;i++)
		{
			currsum+= arr[i];

			if(currsum>=s)
			{
				last=i;
				while(s<currsum && start<last)
				{
					currsum-= arr[start];
					++start;
				}

				if(currsum==s)
				{
					res.add(start + 1);
					res.add(last + 1);
					flag = true;
					break;
				}
			}
		}
		if (flag==false) {
			res.add(-1);
		} 
		return res;    
	}

	public String[] commonCharacters(String[] strings) {

		String [] stringsWithUniqueChars = new String[strings.length];
		for(int i = 0;i<strings.length;i++) {
			stringsWithUniqueChars[i] = getUniqueCharString(strings[i]);
		}

		Map<Character, Integer> charMap = new HashMap<Character, Integer>();

		for(String str : stringsWithUniqueChars) {
			for(int i = 0; i < str.length();i++) {
				if(charMap.containsKey(str.charAt(i))) {
					charMap.put(str.charAt(i), charMap.get(str.charAt(i))+1);
				}
				else {
					charMap.put(str.charAt(i),1);
				}
			}
		}

		List<String> returnList = new ArrayList<String>();
		for(Character key : charMap.keySet()) {
			if(charMap.get(key) == strings.length) {
				returnList.add(String.valueOf(key));
			}
		}

		return returnList.toArray(new String[returnList.size()]);
	}

	private String getUniqueCharString(String str) {
		Set<Character> set = new HashSet<Character>();
		for(int i = 0 ;i<str.length();i++) {
			set.add(str.charAt(i));
		}
		StringBuilder sb = new StringBuilder("");
		for(Character character : set) {
			sb.append(character);
		}

		return sb.toString();
	}

}
