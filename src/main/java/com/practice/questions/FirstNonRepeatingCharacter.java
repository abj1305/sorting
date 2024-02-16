package com.practice.questions;

public class FirstNonRepeatingCharacter {

	public static void main(String args[]) {
		FirstNonRepeatingCharacter f = new FirstNonRepeatingCharacter();
		int i = f.firstNonRepeatingCharacter("abhijeet");
	}

	public int firstNonRepeatingCharacter(String string) {
		int [] arr = new int [26];
		for(char c : string.toCharArray()) {
			arr[c-'a'] ++;
		}
		for(int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if(arr[c-'a'] == 1) {
				
				return i;
			}
		}
		
		return -1;
	}

	//	public int firstNonRepeatingCharacter(String string) {
	//		Map<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
	//		for(int i = 0 ; i < string.length(); i++) {
	//			char c = string.charAt(i);
	//			if(map.containsKey(c)) {
	//				map.get(c).add(i);
	//			}
	//			else {
	//				List<Integer> list = new ArrayList<Integer>();
	//				list.add(i);
	//				map.put(c, list);
	//			}
	//		}
	//		for(char c : string.toCharArray()) {
	//			if(map.get(c).size() == 1) {
	//				return map.get(c).get(0);
	//			}
	//		}
	//		return -1;
	//	}

}
