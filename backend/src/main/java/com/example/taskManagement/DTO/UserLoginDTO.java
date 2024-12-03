package com.example.taskManagement.DTO;

public class UserLoginDTO {

	private String userEmail ; 
	
	private String userPassword ;

	public UserLoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserLoginDTO(String userEmail, String userPassword) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "UserLoginDTO [userEmail=" + userEmail + ", userPassword=" + userPassword + "]";
	}
}
