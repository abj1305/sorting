package com.practice.play;

import java.time.LocalDate;

public class Test {

	public static void main(String[] args) {
		
		LocalDate start = LocalDate.of(2024, 1, 26);
		LocalDate end = LocalDate.of(2024, 2, 25);
		
		LocalDate jd = LocalDate.of(2024, 1, 25);
		
		if(! jd.isBefore(start) && !jd.isAfter(end)) {
			System.out.println("TRUE");
		}
		else {
			System.out.println("FALSE");
		}

	}

}
