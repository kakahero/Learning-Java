package com.test;

public class SingletonTest8 {
	private static class SingletonHolder {
        private static final SingletonTest8 INSTANCE = new SingletonTest8();
    }
    private SingletonTest8 (){}
    public static final SingletonTest8 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
