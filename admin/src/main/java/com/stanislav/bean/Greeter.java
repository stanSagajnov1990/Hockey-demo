package com.stanislav.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.stanislav.GreeterHockeyEJB;

@Named("greeter")
@SessionScoped
public class Greeter implements Serializable{

	private static final long serialVersionUID = 476477822770797943L;

	@EJB
	private GreeterHockeyEJB greeterHockeyEJB;
	
	private String message;
	
	public void setName(String name){
		message = greeterHockeyEJB.sayHello(name);
	}
	
	public String getMessage() {
		return message;
	}
	
}
