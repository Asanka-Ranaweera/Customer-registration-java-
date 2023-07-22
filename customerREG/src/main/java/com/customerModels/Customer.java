package com.customerModels;

public class Customer {
	
	private int id;
	private String name;
	private String email;
	private String phone;
	private String password;
	private String username;
	
	public Customer(int id, String name, String email, String phone, String password, String username) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getPassword() {
		return password;
	}
	
	public String getUsername() {
		return username;
	}


	
	
}
