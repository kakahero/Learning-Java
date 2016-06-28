package com.test;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {

	private final static AtomicIntegerArray atomic_integer_array = new AtomicIntegerArray(new int[]{1,2,3,4,5,6,7,8,9,10});
	
	public static void main(String[] args) throws InterruptedException{
		Thread[] threads = new Thread[100];
		for(int i=0; i<100; i++){
			final int index = i%10;
			final int threadNum = i;
			threads[i] = new Thread(){
				public void run(){
					int result = atomic_integer_array.addAndGet(index, index + 1);
					System.out.println("thread id is: " + threadNum + " origin value is: " + (index + 1) + " new value is: " + result);
				}
			};
			threads[i].start();
		}
		for(Thread thread : threads){
			thread.join();
		}
		System.out.println("finish ---> result of list");
		for(int i=0; i<atomic_integer_array.length(); i++){
			System.out.println(atomic_integer_array.get(i));
		}
	}
}
