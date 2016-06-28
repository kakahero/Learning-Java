package com.test;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanTest {

	public final static AtomicBoolean test_atomicBool = new AtomicBoolean();
	
	public static void main(String[] args){
		for(int i=0; i<10; i++){
			new Thread(){
				public void run(){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(test_atomicBool.compareAndSet(false, true)){
						System.out.println("Hello atomic boolean!");
					}
				}
			}.start();
		}
	}
	
}
