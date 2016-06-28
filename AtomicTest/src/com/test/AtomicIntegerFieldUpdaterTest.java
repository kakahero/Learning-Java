package com.test;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterTest {

	static class A {
		volatile int  intValue = 100;
	}
	
	public final static AtomicIntegerFieldUpdater<A> atomic_integer_updater = AtomicIntegerFieldUpdater.newUpdater(A.class, "intValue");
	
	public static void main(String[] args){
		final A a = new A();
		for(int i=0; i<100; i++){
			final int num = i;
			new Thread(){
				public void run(){
					if(atomic_integer_updater.compareAndSet(a, 100, 120)){
						System.out.println("I'm thread: " + num + " modify value!");
					}
				}
			}.start();
		}
	}
}
