package com.t1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t1.entity.UserEntity;
import com.t1.responsedto.UserResponse;
import com.t1.service.UserService;

@RestController
@RequestMapping("/api/user/")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/getAll")
	public List<UserResponse> getAllUsers(){
		List<UserEntity> userList = userService.getAllUsers();
		List<UserResponse> userResponseList = new ArrayList<UserResponse>();
		
		userList.stream().forEach(user -> {
			userResponseList.add(new UserResponse(user));
		});
		
		return userResponseList;
	}

}
