package com.test;

public class SingletonTest5 {

	private static SingletonTest5 singleton = null;

	private SingletonTest5()  {    }

	public static SingletonTest5 getInstance() {
		if (singleton == null) {
			synchronized (SingletonTest5.class) {
				if (singleton == null) {
					singleton = new SingletonTest5();
				}
			}
		}
		return singleton;
	}

}
