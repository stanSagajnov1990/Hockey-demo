package com.stanislav;

import javax.ejb.Stateful;

@Stateful
public class GreeterHockeyEJB {
	
	public String sayHello(String name){
		return "Hello " + name;
	}
	
	
}
