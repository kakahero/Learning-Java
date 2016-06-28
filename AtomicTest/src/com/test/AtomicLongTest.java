package com.test;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongTest {
	private final static AtomicLong test_atomicLong = new AtomicLong(1);
	private static int test_normalLong = 1;
	
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
					 Long now = test_atomicLong.incrementAndGet();
//					 unsafe
//					test_normalLong += 1;
//					int now = test_normalLong;
					System.out.println("I'm thread: " + num + " I got value, and add it to: " + now);
				}
			};
			threads[i].start();
		}
		for(Thread t : threads){
			t.join();
		}
		System.out.println("The final value is:" + test_normalLong);
		System.out.println("The final value is:" + test_atomicLong.get());
	}
}
