package com.test;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.Observable.OnSubscribe;

public class TestRxJava2 {
	
	public void start(){
		Observable.create(new OnSubscribe<Integer>() {

			@Override
			public void call(Subscriber<? super Integer> subscriber) {
				new Thread(){
					public void run(){
						long threadId = Thread.currentThread().getId();
						subscriber.onNext(1);
					}
				}.start();
//				subscriber.onCompleted();
			}
		}).map(new Func1<Integer, String>(){

			@Override
			public String call(Integer arg0) {
				long threadId = Thread.currentThread().getId();
				return "map threadId: " + threadId;
			}
			
		}).subscribe(new Subscriber<String>() {

			@Override
			public void onCompleted() {
				long threadId = Thread.currentThread().getId();
				System.out.println("onCompleted: " + threadId);
			}

			@Override
			public void onError(Throwable e) {
				
			}

			@Override
			public void onNext(String s) {
				long threadId = Thread.currentThread().getId();
				System.out.println("onNext: " + s + " ThreadId: " + threadId);
			}
		});
	}
}
