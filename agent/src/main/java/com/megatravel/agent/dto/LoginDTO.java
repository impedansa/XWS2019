package com.megatravel.agent.dto;

public class LoginDTO {

	private String email;
	private String password;
	
	public LoginDTO() { }
	
	public LoginDTO(String username, String password) {
		super();
		this.email = username;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}