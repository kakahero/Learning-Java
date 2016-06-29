package com.test;

public class SingletonTest1 {

	private static SingletonTest1 singleton = null;
	private SingletonTest1(){};
	public static SingletonTest1 getInstance(){
		if(singleton == null){
			singleton = new SingletonTest1();
		}
		return singleton;
	}
}
