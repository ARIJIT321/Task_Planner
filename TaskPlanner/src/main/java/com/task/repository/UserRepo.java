package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
