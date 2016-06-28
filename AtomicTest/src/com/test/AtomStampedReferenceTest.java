package com.test;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomStampedReferenceTest {

	public final static AtomicStampedReference<String> atomic_reference = new AtomicStampedReference<String>("abc", 0);
	public static void main(String[] args) {
		for(int i=0; i<100; i++){
			final int num = i;
			final int stamp = atomic_reference.getStamp();
			new Thread(){
				public void run(){
					try {
						Thread.sleep(Math.abs((int)(Math.random()*100)));
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(atomic_reference.compareAndSet("abc", "abc2", stamp, stamp+1)){
						System.out.println("I'm thread: " + num + " I got lock and modify object.");
					}
				}
			}.start();
		}
		new Thread(){
			public void run(){
				int stamp = atomic_reference.getStamp();
				while(!atomic_reference.compareAndSet("abc2", "abc", stamp, stamp+1));
				System.out.println("set to origin value.");
			}
		}.start();
	}
}
