package com.example.taskManagement.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.taskManagement.Entity.User;

@EnableJpaRepositories
@Repository
public interface TaskRepo extends JpaRepository<User , Long> {
	
	User getTaskById(int id);
	
	Optional<User> findOneByEmailAndPassword(String userEmail, String userPassword);
	 
	User findByEmail(String email);
	
	User getUserById(long id);

}
