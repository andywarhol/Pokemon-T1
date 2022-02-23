package com.t1.controller;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.t1.entity.UserEntity;
import com.t1.repository.UserRepository;
import com.t1.requestedto.CreateUserRequest;
import com.t1.requestedto.UpdateUserRequest;
import com.t1.responsedto.UserResponse;
import com.t1.service.UserService;

@RestController
@RequestMapping("/api/user/")
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/create")
	public UserResponse createUser(@RequestBody CreateUserRequest createUserRequest) {
		UserEntity user = userService.createUser(createUserRequest);
		
		return new UserResponse(user);
	}
	
	/*
	@GetMapping("/id/{id}")
	public UserResponse findUserById(@PathVariable Long id) {
		UserEntity user = userRepo.getById(id);
		return new UserResponse(user);
	}
	*/
	/*
	@PatchMapping("/update/{id}")
	public @ResponseBody void saveUser(@PathVariable Long id, @RequestBody Map<Object, Object> fields) {
		UserEntity user = userRepo.getById(id);
		//Map key is field name, v is value
		fields.forEach((k,v) -> {
			
			//use reflection to get field k on user and set it to value k
			Field field = ReflectionUtils.findRequiredField(UserEntity.class,(String)k);
			field.setAccessible(true);
			ReflectionUtils.setField(field, user, v);
			
		});
		userRepo.save(user);
	}
	*/
	
	/*
	private UserEntity applyPatchToUser(JsonPatch patch, UserEntity user) 
			throws JsonProcessingException, IllegalArgumentException, JsonPatchException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode patched = patch.apply(objectMapper.convertValue(user, JsonNode.class));
		return objectMapper.treeToValue(patched, UserEntity.class);
	}
	
	
	@PatchMapping(path = "/update/{id}", consumes = "application/json-patch+json")
	public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody JsonPatch patch) {
		
		try {
		 UserEntity user = userRepo.getById(id); 
		 UserEntity userPatched = applyPatchToUser(patch,(UserEntity) user);
		 return ResponseEntity.ok(userPatched);
		}catch(JsonPatchException | JsonProcessingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	*/
	/*
	@RequestMapping(value="/update/{id}", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<UserEntity> update(@PathVariable Long id,  HttpServletRequest request) throws IOException{
		UserEntity user = userRepo.findOne(id);
		UserEntity updatedUser = objectMapper.readerForUpdating(user).readValue(request.getReader());
		userRepo.saveAndFlush(updatedUser);
		return new ResponseEntity<>(updatedUser, HttpStatus.ACCEPTED);
	}
	*/
	
	@PutMapping("/update")
	public UserResponse updateDetails(@RequestBody UpdateUserRequest updateUserReq) {
		UserEntity updateUser = userService.updateUserDetails(updateUserReq);
		return new UserResponse(updateUser);
	}
	
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
	
	
	
	

}
