package com.mlt;

public class mlt {
     
	private int id;
	private String name;
	private String email;
	private String type;
	private String userName;
	private String password; 
	
	public mlt(int id, String name, String email, String type, String userName, String password) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.type = type;
		this.userName = userName;
		this.password = password;
		
		
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

	

	public String getType() {
		return type;
	}

	

	public String getUserName() {
		return userName;
	}

	

	public String getPassword() {
		return password;
	}

	
	
	
	
}
