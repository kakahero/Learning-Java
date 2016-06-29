package com.test;

import java.util.concurrent.atomic.AtomicReference;

public class SingletonTest9 {
	private static final AtomicReference<SingletonTest9> INSTANCE = new AtomicReference<SingletonTest9>();

	public static SingletonTest9 getInstance() {
		for (;;) {
			SingletonTest9 current = INSTANCE.get();
			if (current != null) {
				return current;
			}
			current = new SingletonTest9();
			if (INSTANCE.compareAndSet(null, current)) {
				return current;
			} else {

			}
		}
	}
}
