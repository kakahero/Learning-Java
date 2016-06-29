package com.test;

public class SingletonTest2 {
	private static SingletonTest2 singleton = null;
    private SingletonTest2() {  }
    public static SingletonTest2 getInstance() {
        if (singleton== null) {
            synchronized (SingletonTest2.class) {
                singleton= new SingletonTest2();
            }
        }
        return singleton;
    }
}
