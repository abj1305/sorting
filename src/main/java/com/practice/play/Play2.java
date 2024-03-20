package com.practice.play;

import java.util.Arrays;

public class Play2 {

	public static void main(String args[]) {
		Play2 p = new Play2();
		String reversedString = p.stringReverse("Abhijeet");
		System.out.println(reversedString);
	}

	public String stringReverse (String name) {
		StringBuilder sb = new StringBuilder();
		Arrays.stream(name.split("")).forEach(c -> sb.insert(0, c));
		String reversedString = sb.toString();
		return reversedString;
	}

}
