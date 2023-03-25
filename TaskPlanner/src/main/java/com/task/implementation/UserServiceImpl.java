package com.task.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.exception.UserException;
import com.task.model.User;
import com.task.repository.UserRepo;
import com.task.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
    private UserRepo userRepository;
	
	@Override
	public User createUser(User user) throws UserException{
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() throws UserException{
		return userRepository.findAll();
	}

}
