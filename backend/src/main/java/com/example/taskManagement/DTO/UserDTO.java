package com.example.taskManagement.DTO;

public class UserDTO {
	
	private long id ; 
	private String name ; 
	private String email ; 
	private String city ; 
	private String password ;
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(long id, String name, String email, String city, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.city = city;
		this.password = password;
	}

	public UserDTO(String name, String email, String city, String password) {
		super();
		this.name = name;
		this.email = email;
		this.city = city;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", email=" + email + ", city=" + city + ", password=" + password
				+ "]";
	} 
	
}
