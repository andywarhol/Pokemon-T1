package com.t1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t1.entity.UserEntity;
import com.t1.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}
	
}

