package com.test;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class TestRxJava3 {

	public void start(){
		Observable.create(new Observable.OnSubscribe<Integer>() {

			@Override
			public void call(Subscriber<? super Integer> subscriber) {
				long threadId = Thread.currentThread().getId();
				System.out.println("call thread id: " + threadId);
				subscriber.onNext(100);
				subscriber.onNext(101);
				subscriber.onNext(102);
				subscriber.onNext(103);
				subscriber.onNext(104);
				subscriber.onNext(105);
				subscriber.onNext(106);
				subscriber.onCompleted();
			}
			
		}).subscribeOn(Schedulers.io())
		.observeOn(Schedulers.newThread())
		.subscribe(new Subscriber<Integer>(){

			@Override
			public void onCompleted() {
				long threadId = Thread.currentThread().getId();
				System.out.println("onCompleted thread id: " + threadId);
			}

			@Override
			public void onError(Throwable e) {
				long threadId = Thread.currentThread().getId();
				System.out.println("onError thread id: " + threadId);
			}

			@Override
			public void onNext(Integer i) {
				long threadId = Thread.currentThread().getId();
				System.out.println("onNext: "  + i + " thread id: " + threadId);
			}
		});
	}
}
