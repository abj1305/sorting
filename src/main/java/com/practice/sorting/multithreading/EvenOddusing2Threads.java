package com.practice.sorting.multithreading;

public class EvenOddusing2Threads {
	
	int count = 0;
	int max = 10;
	
	public static void main (String args []) {
		
		EvenOddusing2Threads obj = new EvenOddusing2Threads();
		
		Thread t1 = new Thread(() -> {
			try {
				obj.printEven();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread(() -> {
			try {
				obj.printOdd();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
		
		
	}
	
	private void printEven () throws InterruptedException {
		while(count < max) {
			synchronized(this) {
				while(count %2 !=0) {
					wait();
				}
				System.out.println(Thread.currentThread().getId() + " " + count++);
				notify();
			}
		}
	}
	
	private void printOdd () throws InterruptedException {
		while(count < max) {
			synchronized(this) {
				while(count %2 ==0) {
					wait();
				}
				System.out.println(Thread.currentThread().getId() + " " + count++);
				notify();
			}
		}
	}

}
