package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.exception.UserException;
import com.task.model.User;
import com.task.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
    private UserService userService;
	
	@PostMapping("/users")
    public User createUser(@RequestBody User user) throws UserException{
        return userService.createUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() throws UserException{
        return userService.getAllUsers();
    }
	
}
