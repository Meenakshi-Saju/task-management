package com.example.taskManagement.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity()
@Table(name="task")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id ; 
	
	private String title ; 
	
	private String description ; 
	
	private String status ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user ; 

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(long id, String title, String description, String status, User user) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.user = user;
	}

	public Task(String title, String description, String status, User user) {
		super();
		this.title = title;
		this.description = description;
		this.status = status;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status + ", user="
				+ user + "]";
	}

	public Task(String title, String description, String status) {
		super();
		this.title = title;
		this.description = description;
		this.status = status;
	}

	

}
