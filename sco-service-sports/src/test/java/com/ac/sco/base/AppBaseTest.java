package com.ac.sco.base;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration("classpath:/spring/app-context.xml")
public abstract class AppBaseTest extends AbstractJUnit4SpringContextTests  {
	
	@BeforeClass
	public static void setup() {
		System.setProperty("env", "test");
	}
	
	@Test
	public void dummyTest(){
		System.out.print("Test initialization class.");
	}
	
	
}
