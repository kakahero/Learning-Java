package com.test;

public class SingletonTest7 {
	private volatile static SingletonTest7 singleton = new SingletonTest7();
    private SingletonTest7()  {    }
    public static SingletonTest7 getInstance()   {
        return singleton;
    }
}
