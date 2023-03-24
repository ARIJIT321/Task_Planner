package com.task.service;

import java.util.List;

import com.task.exception.SprintException;
import com.task.model.Sprint;

public interface SprintService {

	public Sprint createSprint(Sprint sprint) throws SprintException;
	
	public List<Sprint> getAllSprints() throws SprintException;
	
	
}
