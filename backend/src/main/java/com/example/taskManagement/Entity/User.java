package com.example.taskManagement.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity()
@Table(name="usertask")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id ;
	private String name ; 
	private String email ; 
	private String city ; 
	private String password ;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "user")
	private List<Task> task = new ArrayList<Task>();
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long id, String name, String email, String city, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.city = city;
		this.password = password;
	}

	public User(String name, String email, String city, String password) {
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
	
	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", city=" + city + ", password=" + password
				+ "]";
	}
}
