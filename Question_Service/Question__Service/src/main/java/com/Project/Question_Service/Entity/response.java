package com.Project.Question_Service.Entity;

import org.hibernate.boot.model.naming.ImplicitNameSource;

public class response {
	
	private int id;
	private String response;
	
	public response() {
		super();
		// TODO Auto-generated constructor stub
	}

	public response(int id, String response) {
		super();
		this.id = id;
		this.response = response;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	
}
