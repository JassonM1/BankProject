package com.jasson.assignment;

public class CustomerId {
	
	private String id;
	private String name;
	
	public CustomerId() {
		super();
	}
	
	public CustomerId(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CustomerId [id=" + id + ", name=" + name + "]";
	}
	

	
	
	
}
	
	

