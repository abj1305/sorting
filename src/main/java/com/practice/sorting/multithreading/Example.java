package com.practice.sorting.multithreading;

public class Example {
	
	public static void main(String args[]) {
		
		Thread t1 = new Thread(() -> {
			try {
				method();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread(() -> {
			try {
				method();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
	}

	public static void method() throws Exception {
		System.out.println(Thread.currentThread().getName());
		Thread.sleep(5000);
		System.out.println(Thread.currentThread().getName());
	}

}
