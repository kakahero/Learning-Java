package com.test;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceABATest {

	public final static AtomicReference<String> Atomic_reference = new AtomicReference<String>("abc");
	
	public static void main(String[] args){
		for(int i=0; i<100; i++){
			final int num = i;
			new Thread(){
				public void run(){
					try {
						Thread.sleep(Math.abs((int)(Math.random()*100)));
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(Atomic_reference.compareAndSet("abc", "abc2")){
						System.out.println("I'm thread: " + num + " I got lock and modify object");
					}
				}
			}.start();
		}
		new Thread(){
			public void run(){
				while(!Atomic_reference.compareAndSet("abc2", "abc"));
				System.out.println("have setted orgin value");
			}
		}.start();
	}
}
