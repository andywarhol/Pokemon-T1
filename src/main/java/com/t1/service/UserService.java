package com.t1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t1.entity.UserEntity;
import com.t1.repository.UserRepository;
import com.t1.requestedto.CreateUserRequest;
import com.t1.requestedto.UpdateUserRequest;
import com.t1.responsedto.UserResponse;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	UserResponse userResponse;
	
	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}
	
	public UserEntity createUser(CreateUserRequest createUserRequest) {
		UserEntity user = new UserEntity(createUserRequest);
		
		user = userRepository.save(user);
		
		return user;
	}
	
	public UserEntity updateUser(UpdateUserRequest updateUserRequest) {
		UserEntity user = userRepository.findById(updateUserRequest.getId()).get();
		
		if(updateUserRequest.getTeamName() != null &&
				!updateUserRequest.getTeamName().isEmpty()) {
			user.setTeamName(updateUserRequest.getTeamName());
		} 
		
		if (updateUserRequest.getTrainerName() !=null && 
				! updateUserRequest.getTrainerName().isEmpty()) {
			user.setTrainerName(updateUserRequest.getTrainerName());
		} 

		if(updateUserRequest.getRol() != null &&
				! updateUserRequest.getRol().isEmpty()) {
			user.setRol(updateUserRequest.getRol());
		} 
		
		if (updateUserRequest.getUsername() != null &&
				! updateUserRequest.getUsername().isEmpty()) {
			user.setUsername(updateUserRequest.getUsername());
		} 
		
		if (updateUserRequest.getPassword() != null &&
				! updateUserRequest.getPassword().isEmpty()) {
			user.setPassword(updateUserRequest.getPassword());
		}
		
		user = userRepository.save(user);
		return user;
	}
	
	public String deleteStudent (UserEntity user) {
		userRepository.delete(user);
		return "Se ha borrado el usuario";
	}
	
}

