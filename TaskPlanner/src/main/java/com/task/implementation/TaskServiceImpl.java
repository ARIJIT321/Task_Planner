package com.task.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.exception.SprintException;
import com.task.exception.TaskException;
import com.task.model.Task;
import com.task.repository.SprintRepo;
import com.task.repository.TaskRepo;
import com.task.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
    private TaskRepo taskRepository;
	
	@Autowired
    private SprintRepo sprintRepository;
	
	@Override
	public Task createTask(Task task) throws TaskException{
		return taskRepository.save(task);
	}

	@Override
	public List<Task> getTasksBySprintId(Integer sprintId) throws SprintException{
		return sprintRepository.findById(sprintId).get().getTasklist();
	}

	@Override
	public List<Task> getTasksByAssignee(String assignee) throws TaskException {
		return taskRepository.findByAssignee(assignee);
	}

	@Override
	public Task updateTaskStatus(Integer taskId, String status) throws TaskException {
		Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskException());
        task.setStatus(status);
        return taskRepository.save(task);
	}

	@Override
	public Task updateTaskAssignee(Integer taskId, String assignee) throws TaskException {
		Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskException());
        task.setAssignee(assignee);
        return taskRepository.save(task);
	}

	


}
