package com.practice.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Questions {

	public static void main(String args []) {

		Set<Integer> set = new HashSet<Integer>();
		
		int a1 [] = {13, 17, 18, 19, 20, 22, 22, 27, 36, 39, 46, 48, 50};
		int a2 [] = {4, 12, 45};
		
		List<Integer> list = findUnion(a1,a2,a1.length, a2.length);
		System.out.println(list);
		
	}
	
	
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
