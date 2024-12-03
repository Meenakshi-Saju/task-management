package com.example.taskManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskManagement.DTO.TaskDTO;
import com.example.taskManagement.DTO.UserDTO;
import com.example.taskManagement.DTO.UserLoginDTO;
import com.example.taskManagement.Entity.Task;
import com.example.taskManagement.Entity.User;
import com.example.taskManagement.Repo.TaskRepo;
import com.example.taskManagement.Repo.TaskRepository;

//Service Class
@Service
public class TaskService {
	
	private TaskRepo taskRepo ;
	
	private TaskRepository taskRepository ; 
	
	private long userId ; 
	
	private String userEmail ; 

	@Autowired
	public TaskService(TaskRepo taskRepo , TaskRepository taskRepository) {
		super();
		this.taskRepo = taskRepo;
		this.taskRepository = taskRepository ; 
	} 
	
	//User Registration Method. 
	public Long addUsers(UserDTO userDTO) {
		
		//Getting All User Details for Registration from UI and Storing in User Entity Object
		User user = new User(userDTO.getName(),
							userDTO.getEmail(),
							userDTO.getCity(),
							userDTO.getPassword());
		
		//Storing User Data into Database using JPA Repository
		taskRepo.save(user);
		
		this.userId = user.getId();
		
		return userId;
	}
	
	//User Login Method
	public String loginUsers(UserLoginDTO userLoginDTO) {
		
		//First Fetching User from the Email which is Entered by User in the Login Page
		User user = taskRepo.findByEmail(userLoginDTO.getUserEmail());
		
		this.userEmail = userLoginDTO.getUserEmail();
		
		
		
		try {
			
			this.userId = user.getId();
			
			//Checking whether the particular User is present or not.
			if(user!=null)
			{
				String pass1 = userLoginDTO.getUserPassword();
				String pass2 = user.getPassword();
				
				//Checking Passwords
				if(pass1.equals(pass2))
				{
					Optional<User> user1 = taskRepo.findOneByEmailAndPassword(userLoginDTO.getUserEmail(), pass2);
					
					//If particular user email and password matches the user login successfull otherwise it gives some alert message.
					if(user1.isPresent())
					{
						return this.userEmail;
					}
					else
					{
						return "Login Failed";
					}
				}
				else
				{
					return "Password Does Not Match";
				}
			} 
			else 
			{
				return "Email Does Not Exists";
			}
		}
		catch(Exception e) {
			return "Login Failed";
		}		
	}
	
	// Add Task Method
	public String addUserTasks(TaskDTO taskDTO) {
		
		//Getting All Task Details for Adding Task from UI and Storing in Task Entity Object.
		Task task = new Task(
							taskDTO.getTitle(),
							taskDTO.getDescription(),
							taskDTO.getStatus());
		
		
		User user = taskRepo.getUserById(this.userId);
		
		//Setting the task details which is belonging to particular user.
		task.setUser(user);
		
		user.getTask().add(task);
		
		taskRepo.save(user);
		
		return task.getTitle();
	}

	//Fetching All The User Details 
	public List<User> getUsers() {
		
		return taskRepo.findAll();
	}
	
	//Fetching All Task Details and Storing Task Details into List 
	public List<Task> getAllTasksById(long id)
	{
		User user = taskRepo.getUserById(this.userId);
		List<Task> userContacts1 = user.getTask();
		
		
		if(userContacts1!=null)
		{	
			System.out.print("All Contacts : - "+userContacts1);
			return userContacts1;
		}
		
		return null ;
		
	}
	
	//Fetching All Task Details and Storing Task Details into Task Object
	public Task getTasks(long id)
	{
		Task t1 = taskRepository.getTaskById(id);
		System.out.print(t1);
		return t1 ; 
	}
	
	//Update Task Method
	public String updateData(TaskDTO taskDTO , long id)
	{
		
		Optional<Task> opTask = taskRepository.findById(id);
		
		Task task = new Task(
				taskDTO.getTitle(),
				taskDTO.getDescription(),
				taskDTO.getStatus());
		
		
		if(opTask.isPresent()) {
			
			Task task1 = opTask.get();
			
			task1.setTitle(task.getTitle());
			task1.setDescription(task.getDescription());
			task1.setStatus(task.getStatus());
			
			taskRepository.save(task1);
			
			return"Success";
		}
		else {
			return "Failure";
		}
	}
	
	//Delete Task Method
	public void deleteData(long id)
	{
		taskRepository.deleteById(id);

	}
	
	
	

}
