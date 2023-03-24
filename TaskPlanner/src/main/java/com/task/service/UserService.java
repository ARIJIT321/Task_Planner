package com.task.service;

import java.util.List;

import com.task.exception.UserException;
import com.task.model.User;

public interface UserService {
	
	public User createUser(User user) throws UserException;
	
	public List<User> getAllUsers() throws UserException;
}
