package com.practice.sorting.multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class EvenOddMultiThreading {

	static int limit = 10;
	static int counter = 0;
	
	public static void main(String[] args) {
		EvenOddMultiThreading m = new EvenOddMultiThreading();
		Thread t1 = new Thread(()->{
			try {
				m.print1();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread(() -> {
			try {
				m.print0();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread t3 = new Thread(() -> {
			try {
				m.print2();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Executor executor = Executors.newFixedThreadPool(3);
		executor.execute(t1);
		executor.execute(t2);
		executor.execute(t3);

	}

	private void print0() throws InterruptedException {

		synchronized (this) {
			while(counter < limit) {
				if(counter % 3 == 0) {
					System.out.println("1: " + counter++);
					notifyAll();
					
				}
				else {
					wait();
				}
				
			}
		}
		
	}

	private void print1() throws InterruptedException {
		while(counter < limit) {
			synchronized (this) {
				if(counter%3 == 1) {
					System.out.println("2: " + counter++);
					notifyAll();
				}
				else {
					wait();
				}
				
			}
		}
	}
	
	private void print2() throws InterruptedException {
		while(counter < limit) {
			synchronized (this) {
				if(counter%3 == 2) {
					System.out.println("3: " + counter++);
					notifyAll();
				}
				else {
					wait();
				}
				
			}
		}
	}
	
	
}
