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
		int [] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} ;
		q.minJumps(arr);
		
	}
	
	
	//https://www.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1?page=1&sortBy=submissions
    static int minJumps(int[] arr){
        int cur=0, count=0;
        while(cur < arr.length) {
        	int max = 0;
        	for(int i=cur ; i<cur+arr[cur] && i < arr.length ; i++) {
        		if(arr[i] > max) {
        			max = arr[i];
        		}
        	}
        	if(cur+max >= arr.length) {
        		return ++count;
        	}
        	if(arr[cur+max] == 0) {
        		max--;
        	}
        	cur = cur + max;
        	count++;
        }
        return count;
        
    }
	
	
	// https://www.geeksforgeeks.org/problems/angle-between-hour-and-minute-hand0545/1?page=1&company=Salesforce&sortBy=submissions
	static int getAngle(int hour , int minute) {
        // code here
        float m = minute*6;
        float c = ((float)minute/60) * 30;
        float h = hour*30 + c;
        float ans = Math.abs(h-m);
        float b = 360 - ans;
        return (int)Math.floor((Math.min(ans,b)));
        
    }
	
	//https://www.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1?page=1&company=Salesforce&sortBy=submissions
    int getPairsCount(int[] arr, int pairs, int k) {
        pairs = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : arr) {
        	int t = k-i;
        	if(map.containsKey(t)) {
        		pairs = pairs + map.get(t);
        	}
        	if(map.containsKey(i)) {
        		map.put(i, map.get(i)+1);
        	}
        	else {
        		map.put(i, 1);
        	}
        }
        return pairs;
    }
	
	//https://www.geeksforgeeks.org/problems/find-k-th-smallest-element-in-bst/1?page=1&category=Binary%20Search%20Tree&sortBy=submissions
    static int k;
	public int KthSmallestElement(Node root, int K) {
		k=K;
    	int e = kthSmallest(root);
    	return e;
    }
    private int kthSmallest(Node node) {
    	if(node.left!=null) {
    		int n = kthSmallest(node.left); 
    		if(n>0) {
    			return n;
    		}
    	}
    	k = k-1;
    	if(k == 0) return node.data;
    	if(node.right != null) {
    		int n = kthSmallest(node.right);
    		if(n>0) {
    			return n;
    		}
    	}
    	return -1;
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
