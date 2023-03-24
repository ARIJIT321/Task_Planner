package com.task.service;

import java.util.List;

import com.task.exception.SprintException;
import com.task.exception.TaskException;
import com.task.model.Task;

public interface TaskService {

	public Task createTask(Task task) throws TaskException; 
	
	public List<Task> getTasksBySprintId(Integer sprintId) throws SprintException;
	
	public List<Task> getTasksByAssignee(String assignee) throws TaskException;
	
	public Task updateTaskStatus(Integer taskId, String status) throws TaskException;
	
	public Task updateTaskAssignee(Integer taskId, String assignee) throws TaskException;
	
	
}
