package com.test;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
	public final static AtomicReference<String> ATOMIC_REFERENCE = new AtomicReference<String>("abc");
	public final static String NomalString  = "abc";
	
	public static void main(String[] args){
		for(int i=0; i<10; i++){
			final int num = i;
			new Thread(){
				public void run(){
					try {
						Thread.sleep(Math.abs((int)(Math.random() * 100)));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
//					if(NomalString.equals("abc")){
//						System.out.println("I'm thread:" + num + " I get object lock!");
//					}
					if(ATOMIC_REFERENCE.compareAndSet("abc", new String("dc"))){
						System.out.println("I'm thread:" + num + " I get object lock!");
					}
				}
			}.start();
		}
	}
}
