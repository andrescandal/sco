package com.ac.sco.sportsservice.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Levanta el contexto de spring y lo disponibiliza para la app.
 * @author MIsola
 *
 */
public class SpringContext {

	    static ApplicationContext applicationContext = null;
	    static {
	    	applicationContext = new ClassPathXmlApplicationContext("classpath:spring/app-context.xml");
	    }

	    public static ApplicationContext getContext() {
	        return  applicationContext;
	    }
}
