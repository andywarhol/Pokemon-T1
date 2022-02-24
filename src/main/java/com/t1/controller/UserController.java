package com.t1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.t1.entity.PokemonEntity;
import com.t1.entity.UserEntity;
import com.t1.requestedto.CreatePokemonRequest;
import com.t1.requestedto.CreateUserRequest;
import com.t1.requestedto.InsertPokemonRequest;
import com.t1.requestedto.UpdateUserRequest;
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
	
	@GetMapping("/getAllByUser/{username}")
	public List<UserResponse> getByUser(@PathVariable String username){
		List<UserEntity> userList = userService.getByUser(username);
		List<UserResponse> userResponseList = new ArrayList<UserResponse>();
		
		userList.stream().forEach(user -> {
			userResponseList.add(new UserResponse(user));
		});
		
		return userResponseList;
	}
	
	
	@PostMapping("/create")
	public UserResponse createUser(@RequestBody CreateUserRequest createUserRequest) {
		UserEntity user = userService.createUser(createUserRequest);
		
		return new UserResponse(user);
	}
	
	@PostMapping("/insertPokemon/{id}")
	public UserResponse insertPokemon(@RequestBody InsertPokemonRequest insertPokemonRequest) {

		UserEntity user = userService.insertPokemon(insertPokemonRequest);
		
		return new UserResponse(user);
		
	}
	
	@DeleteMapping("/delete")
	public String deletePokemon(@RequestParam long id) {
		return userService.deletePokemon(id);
	}
	
	@PutMapping("/update")
	public UserResponse updateDetails(@RequestBody UpdateUserRequest updateUserReq) {
		UserEntity updateUser = userService.updateUserDetails(updateUserReq);
		return new UserResponse(updateUser);
	}
	

}
