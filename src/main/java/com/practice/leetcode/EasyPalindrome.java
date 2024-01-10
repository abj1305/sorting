package com.practice.leetcode;

public class EasyPalindrome {

	public static void main(String args[]) {
		EasyPalindrome e = new EasyPalindrome();

		boolean b = e.isPalindrome("A man, a plan, a canal: Panama");
		System.out.println(b);
	}

	public boolean isPalindrome(String s) {
		s = s.toUpperCase();
		int l = 0 ;
		int r = s.length()-1;
		while(l<r) {
			while(! isValid((int) s.charAt(l)) && l<r) {
				l++;
			}
			while(! isValid((int) s.charAt(r)) && l<r) {
				r--;
			}
			if(s.charAt(l) != s.charAt(r)) {
				return false;
			}
			else {
				l++;
				r--;
			}
		}
		System.gc();
		return true;
	}

	private boolean isValid(int tmp) {
		return (48<=tmp && tmp <= 57) ||(tmp >=65 && tmp <=90);
	}

	public boolean isPalindrome2(int x) {
		String str = String.valueOf(x);
		for(int i = 0 ; i < str.length()/2; i++) {
			if(str.charAt(i) != str.charAt(str.length()-1-i)) {
				return false;
			}
		}
		return true;
	}

	public boolean isPalindrome(int x) {
        if(x < 0) return false;
		int reverse = 0;
		int number = x;
		int reminder = 0;		
		while(number !=0) {
			reminder = number %10;
			reverse = reverse*10 + reminder;
			number = number / 10;
		}
		return x == reverse;
	}

}
