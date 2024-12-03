package com.example.taskManagement.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskManagement.DTO.TaskDTO;
import com.example.taskManagement.DTO.UserDTO;
import com.example.taskManagement.DTO.UserLoginDTO;
import com.example.taskManagement.Repo.TaskRepo;
import com.example.taskManagement.Service.TaskService;
import com.example.taskManagement.Entity.Task;

@RestController
@RequestMapping("api/v1/task")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

	@Autowired
	private TaskRepo taskRepo ; 
	
	public Long userId ; 
	
	private String email ;
	
	@Autowired
	private TaskService taskService ; 
	
	//User Registration API Route 
	@PostMapping(path = "/saveuser")
	public Long saveUsers(@RequestBody UserDTO userDTO) {
		userId = taskService.addUsers(userDTO);
		return userId ; 
	}
	
	//User Login API Route 
	@PostMapping(path = "/loginusers")
	public String loginUser(@RequestBody UserLoginDTO userLoginDTO)
	{
		String msg = taskService.loginUsers(userLoginDTO);
		this.email = msg ; 
        return msg;
	}
	
	//Add Task API Route 
	@PostMapping(path = "/addtask")
	public String addTasks(@RequestBody TaskDTO taskDTO) {
		String t1 = taskService.addUserTasks(taskDTO);
		return t1 ; 
	}
	
	//Get All Tasks API Route 
	@GetMapping(path = "/gettask")
	public List<Task> getAllTask(){
		List<Task> empty = new ArrayList<Task>();
		
		try {
			List<Task> tasks = taskService.getAllTasksById(this.userId);
			if(tasks!=null) {
				return tasks ; 
			}
			else {
				return empty ; 
			}
		}
		catch(Exception e) {
			System.out.print("Exception Occures : "+e);
			return empty;
		}
	}
	
	//API Route for Getting All Tasks Details for Updating Tasks 
	@GetMapping(path = "/updatetask/{taskid}")
	public Task updateTaskData(@PathVariable long taskid)
	{
		Task task = taskService.getTasks(taskid);
		return task ; 
	}
	
	//Update Task API Route 
	@PostMapping(path = "/updatetask/{taskid}")
	public String updateTask(@RequestBody TaskDTO taskDTO ,@PathVariable long taskid) {
		return taskService.updateData(taskDTO, taskid);
	}
	
	//Delete Task API Route 
	@DeleteMapping(path = "/updatetask/{taskid}")
	public String deleteTask(@PathVariable long taskid) {
		taskService.deleteData(taskid);
		return "Success";
	}
		
}
