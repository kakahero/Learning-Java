package com.test;

public class Test {

	@org.junit.Test
	public void test() {
		for(int i=0; i<20; i++){
			SingletonTest6.getInstance();
		}		
	}

}
