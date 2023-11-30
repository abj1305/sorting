package com.practice.corejava;

public class StringBasics1 {

	public static void main(String[] args) {
		
		String s1 = "Abhijeet";
		String s2 = "Abhijeet";
		
		System.out.println(s1 == s2);
		
		String s3 = new String("Abhijeet");
		String s4 = new String("Abhijeet");
		
		System.out.println(s3 == s4);

	}

}
