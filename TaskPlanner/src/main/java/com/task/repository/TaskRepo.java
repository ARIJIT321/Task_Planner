package com.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.model.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer>{

	 List<Task> findBySprintId(Integer sprintId);
	 
	 List<Task> findByAssignee(String assignee);
	
}
