package com.task.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.exception.SprintException;
import com.task.model.Sprint;
import com.task.repository.SprintRepo;
import com.task.service.SprintService;

@Service
public class SprintServiceImpl implements SprintService{

	@Autowired
    private SprintRepo sprintRepository;
	
	@Override
	public Sprint createSprint(Sprint sprint) throws SprintException{
		return sprintRepository.save(sprint);
	}

	@Override
	public List<Sprint> getAllSprints() throws SprintException{
		return sprintRepository.findAll();
	}

}
