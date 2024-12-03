package com.example.taskManagement.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.taskManagement.Entity.Task;

@EnableJpaRepositories
@Repository
public interface TaskRepository extends JpaRepository<Task , Long> {
	
	Optional<Task> findById(long id);
	
	Task getTaskById(long id);

}
