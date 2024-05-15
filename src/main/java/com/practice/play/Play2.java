package com.practice.play;

import java.util.Arrays;

public class Play2 {

	public static void main(String args[]) {
		Play2 p = new Play2();
		String reversedString = p.stringReverse("Abhijeet");
		System.out.println(reversedString);
		
		Children c = new Children();
		c.walk();
		c.talk();
		
		
	}

	public String stringReverse (String name) {
		StringBuilder sb = new StringBuilder();
		Arrays.stream(name.split("")).forEach(c -> sb.insert(0, c));
		String reversedString = sb.toString();
		return reversedString;
	}

}


class Father {
	public void walk() {
		System.out.println("Walk like father");
	}
	
	public void talk() {
		System.out.println("Talk like father");
	}
}

class Mother {
	public void walk() {
		System.out.println("Walk like mother");
	}
	
	public void talk() {
		System.out.println("Talk like mother");
	}
}

class Children extends Father {
	Mother m = new Mother();
	public void talk() {
		m.talk();
	}
}
