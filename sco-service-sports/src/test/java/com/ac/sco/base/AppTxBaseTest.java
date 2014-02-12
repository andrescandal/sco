package com.ac.sco.base;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration("classpath:/spring/app-context.xml")
public abstract class AppTxBaseTest extends AbstractTransactionalJUnit4SpringContextTests  {
	
	@BeforeClass
	public static void setup() {
		System.setProperty("env", "test");
	}
	
	@Test
	public void dummyTest(){
		System.out.print("Test initialization class.");
	}
	
	
}
