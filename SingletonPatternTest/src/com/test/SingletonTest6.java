package com.test;

public class SingletonTest6 {
	private volatile static SingletonTest6 singleton = null;
    private SingletonTest6()  {    }
    public static SingletonTest6 getInstance()   {
        if (singleton== null)  {
            synchronized (SingletonTest6.class) {
                if (singleton== null)  {
                    singleton= new SingletonTest6();
                }
            }
        }
        return singleton;
    }
}
