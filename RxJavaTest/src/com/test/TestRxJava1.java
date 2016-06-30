package com.test;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

public class TestRxJava1 {

	public void start(){
		Observable.create(new OnSubscribe<Integer>() {

			@Override
			public void call(Subscriber<? super Integer> subscriber) {
				new Thread(){
					public void run(){
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						subscriber.onNext(1);
					}
				}.start();
				
				subscriber.onCompleted();
			}
		}).subscribe(new Subscriber<Integer>(){

			@Override
			public void onCompleted() {
				long threadId = Thread.currentThread().getId();
				System.out.print("onCompleted thread id: " + threadId);
			}

			@Override
			public void onError(Throwable e) {
				
			}

			@Override
			public void onNext(Integer i) {
				long threadId = Thread.currentThread().getId();
				System.out.println("onNext: " + i + " threadId: " + threadId);
			}
			
		});
	}
}
