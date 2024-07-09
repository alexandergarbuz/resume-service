package com.garbuz.resume.model;

public class LoginDTO {
    private String name;
    private String email;
    private String password;
    private String token;
    private boolean loggedin;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public boolean isLoggedin() {
		return loggedin;
	}
	public void setLoggedin(boolean loggedin) {
		this.loggedin = loggedin;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "LoginDTO [name=" + name + ", email=" + email + ", password=" + password + ", token=" + token + ", loggedin=" + loggedin + "]";
	}

	
}
