package com.jasson.bank;

import com.jasson.assignment.CustomerId;

import io.javalin.http.Handler;

public class HelloController {

	public static Handler sayHello=ctx->{
		ctx.result("Hello from handler");
	};
	
	public static Handler getData=ctx->{
		ctx.json("Hello World");
	};
	
	public static Handler getCustomer=ctx->{
		CustomerId customer1 = new CustomerId("C009", "Monkey D, Luffy");
		ctx.json(customer1);
	};
}
