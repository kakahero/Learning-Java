package com.test;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

	private final static AtomicInteger test_atomicInt = new AtomicInteger(1);
	private static int test_normalInt = 1;
	
	public static void main(String[] args) throws InterruptedException{
		final Thread[] threads = new Thread[10];
		for(int i=0; i<10; i++){
			final int num = i;
			threads[i] = new Thread(){
				public void run(){
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}					
					// safe
					// int now = test_atomicInt.incrementAndGet();
					// unsafe
					test_normalInt += 1;
					int now = test_normalInt;
					System.out.println("I'm thread: " + num + " I got value, and add it to: " + now);
				}
			};
			threads[i].start();
		}
		for(Thread t : threads){
			t.join();
		}
		System.out.println("The final value is:" + test_normalInt);
		// System.out.println("The final value is:" + test_atomicInt.get());
	}
}
