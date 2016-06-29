package com.test;

public class Test {

	@org.junit.Test
	public void test() {
		for(int i=0; i<1000000000; i++){
			SingletonTest8.getInstance();
		}		
	}

}
