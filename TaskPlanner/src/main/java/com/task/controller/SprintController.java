package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.exception.SprintException;
import com.task.model.Sprint;
import com.task.service.SprintService;

@RestController
@RequestMapping("/sprint")
public class SprintController {

	@Autowired
    private SprintService sprintService;
	
	@PostMapping("/sprints")
    public Sprint createSprint(@RequestBody Sprint sprint) throws SprintException {
        return sprintService.createSprint(sprint);
    }

    @GetMapping("/sprints")
    public List<Sprint> getAllSprints() throws SprintException {
        return sprintService.getAllSprints();
    }

	
}
