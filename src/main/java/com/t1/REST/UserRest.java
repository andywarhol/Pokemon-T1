package com.t1.REST;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t1.entity.UserEntity;
import com.t1.requestedto.CreateUserRequest;
import com.t1.requestedto.UpdateUserRequest;
import com.t1.responsedto.UserResponse;
import com.t1.service.UserService;

@RestController
@RequestMapping("/api/pokeapi/")
public class UserRest {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	private String inicio() {
		return "Api funcionando correctamente";
	}
	
	@PostMapping("createUser")
	public UserResponse agregarUsuario(@RequestBody CreateUserRequest createUserRequest){
		UserEntity user = userService.createUser(createUserRequest);
			
		return new UserResponse(user);
	}
	
	@GetMapping("getAll")
	private ResponseEntity<List<UserEntity>> getAll(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@PutMapping("modifyUser")
	public UserResponse modifyUser(@Valid @RequestBody UpdateUserRequest updateUserRequest) {
		UserEntity user = userService.updateUser(updateUserRequest);
		return new UserResponse(user);
	}
	
}
