package com.test;

public class SingletonTest3 {
	private static SingletonTest3 singleton = null;
    private SingletonTest3() {  }
    public static SingletonTest3 getInstance() {
        if (singleton== null) {
            synchronized (SingletonTest3.class) {
                singleton= new SingletonTest3();
            }
        }
        return singleton;
    }
}
