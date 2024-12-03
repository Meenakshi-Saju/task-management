package com.example.taskManagement.DTO;

public class TaskDTO {
	
	private int id ; 
	private String title ; 
	private String description ; 
	private String status ;
	
	public TaskDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaskDTO(int id, String title, String description, String status) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
	}

	public TaskDTO(String title, String description, String status) {
		super();
		this.title = title;
		this.description = description;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	@Override
	public String toString() {
		return "TaskDTO [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status + "]";
	} 
	
	
	
	

}
