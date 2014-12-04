package com.ygxhj.test;

import junit.framework.TestCase;

public class Test extends TestCase{

	public void testRun(){
		System.out.println(Runtime.getRuntime().availableProcessors());
	}
	
	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());
	}
}
