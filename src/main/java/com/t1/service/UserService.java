package com.t1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t1.entity.UserEntity;
import com.t1.repository.UserRepository;
import com.t1.requestedto.CreateUserRequest;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}
	
	public UserEntity createUser(CreateUserRequest createUserRequest) {
		UserEntity user = new UserEntity(createUserRequest);
		
		user = userRepository.save(user);
		
		return user;
	}
	
}

