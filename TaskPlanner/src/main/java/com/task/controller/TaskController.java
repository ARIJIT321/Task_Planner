package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.task.exception.SprintException;
import com.task.exception.TaskException;
import com.task.model.Sprint;
import com.task.model.Task;
import com.task.service.SprintService;
import com.task.service.TaskService;
import com.task.service.UserService;

public class TaskController {

	@Autowired
    private TaskService taskService;

    @Autowired
    private SprintService sprintService;

 


    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) throws TaskException {
        return taskService.createTask(task);
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


    @PostMapping("/sprints")
    public Sprint createSprint(@RequestBody Sprint sprint) throws SprintException {
        return sprintService.createSprint(sprint);
    }

    @GetMapping("/sprints")
    public List<Sprint> getAllSprints() throws SprintException {
        return sprintService.getAllSprints();
    }

	
}
