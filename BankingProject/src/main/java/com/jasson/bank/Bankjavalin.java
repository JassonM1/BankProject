package com.jasson.bank;

import io.javalin.Javalin;

public class Bankjavalin {
public static void main(String[] args) {
	Javalin app = Javalin.create().start();
	
	//app.get("/", ctx -> ctx.result("Hello World"));
	
	//app.get("/hello/{name}", ctx-> ctx.result(ctx.pathParam("name").toUpperCase()));
	
	//app.get("/hellohandler", HelloController.sayHello);
	
	//app.get("/data", HelloController.getData);
	
	//app.get("/customer", HelloController.getCustomer);
	
	app.get("/GetAll", CustomerController.getAllCustomer);
	
	app.post("/addcustomer", CustomerController.createCustomer);
	
	app.put("/updatecustomer", CustomerController.updateCustomer);
	
	app.delete("/deletecustomer", CustomerController.deleteCustomer);
	
	app.get("/GetId/{Id}", CustomerController.CustomerId);
	
	app.get("/GetAccount/{Id}", AccountController.getAllAccounts);
	
	app.post("/AddAccount", AccountController.createAccount);
}


}

