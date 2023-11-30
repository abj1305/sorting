package com.practice.sorting.multithreading;

public class MultiThreadingBasic {

	static int counter = 0;
	static int max = 10;

	public static void main(String args []) {
		Thread t1 = new Thread(() -> {
			while(counter < max) {
				System.out.println("Thread 1: " + counter++);	
			}
			
		});

		Thread t2 = new Thread(() -> {
			while(counter < max) {
				System.out.println("Thread 2: " + counter++);	
			}
			
		});
		
		t1.start();
		t2.start();

	}

}
