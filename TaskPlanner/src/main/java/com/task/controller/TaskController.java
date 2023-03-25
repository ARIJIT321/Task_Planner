package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.exception.SprintException;
import com.task.exception.TaskException;
import com.task.model.Task;
import com.task.repository.TaskRepo;
import com.task.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
    private TaskService taskService;

	@Autowired
    private TaskRepo taskRepository;


    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) throws TaskException {
        return taskService.createTask(task);
    }
    
    @GetMapping("/tasks")
    public List<Task> createTask() throws TaskException {
        return taskRepository.findAll();
    }

    @GetMapping("/tasks/sprint/{sprintId}")
    public List<Task> getTasksBySprintId(@PathVariable Integer sprintId) throws SprintException {
        return taskService.getTasksBySprintId(sprintId);
    }

    @GetMapping("/tasks/assignee/{assignee}")
    public List<Task> getTasksByAssignee(@PathVariable String assignee) throws TaskException {
        return taskService.getTasksByAssignee(assignee);
    }

    @PutMapping("/tasks/{taskId}/status/{status}")
    public Task updateTaskStatus(@PathVariable Integer taskId, @PathVariable String status) throws TaskException {
        return taskService.updateTaskStatus(taskId, status);
    }

    @PutMapping("/tasks/{taskId}/assignee/{assignee}")
    public Task updateTaskAssignee(@PathVariable Integer taskId, @PathVariable String assignee) throws TaskException {
        return taskService.updateTaskAssignee(taskId, assignee);
    }


   
	
}
