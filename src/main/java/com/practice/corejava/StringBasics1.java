package com.practice.corejava;

public class StringBasics1 {

	public StringBasics1() {
		System.out.println("Default constr in StringBasic1");
	}
	
	public StringBasics1(String str) {
		System.out.println("Parameterized constr in StringBasic1");
	}
	
	public static void main(String[] args) {
		
		StringBasics1 s = new StringBasics1("s");
		//StringBasics1 s1 = new StringBasics1();
		

	}

}
