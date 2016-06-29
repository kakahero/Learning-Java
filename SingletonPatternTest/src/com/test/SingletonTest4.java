package com.test;

public class SingletonTest4 {

	private static SingletonTest4 singleton = null;
	private SingletonTest4()  {  }
	public static SingletonTest4 getInstance() {
		synchronized (SingletonTest4.class) {
			if (singleton == null) {
				singleton = new SingletonTest4();
			}
		}
		return singleton;
	}

}
