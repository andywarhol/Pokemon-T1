package com.t1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t1.entity.PokemonEntity;
import com.t1.entity.PokemonTypeEntity;
import com.t1.entity.UserEntity;
import com.t1.requestedto.CreateUserRequest;
import com.t1.requestedto.DeletePokemonRequest;
import com.t1.responsedto.PokemonResponse;
import com.t1.responsedto.ResponseDTO;
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
	
	
	/*
	@DeleteMapping("/deletepokemon")
	public ResponseEntity<ResponseDTO<String>> deletePokemonFromUser(@RequestBody DeletePokemonRequest pokemon){
		UserEntity user = userService.findUserById(pokemon.getIdUser());
		
			response = userService.deletePokemon(pokemon.getIdPokemon());
		
		ResponseDTO<String> res = new ResponseDTO<String>("The request was right", response);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	*/
	@DeleteMapping("/delete")
	public ResponseDTO<String> deletePokemonFromUser(@RequestBody DeletePokemonRequest pokemon){
		UserEntity user = userService.findUserById(pokemon.getIdUser());
		ResponseDTO<String> pkm = null;
		String s ="";
		
		if(user.getPkmTeam().size()<=1) {
			System.out.println("ERRrororor");
		}else {
			 s= userService.deletePokemon(pokemon.getIdPokemon());
			 pkm=new ResponseDTO<>("deleetd", s);
		}
		return pkm;
	}
	
	/*
	@DeleteMapping("/delet")
	public List<PokemonTypeEntity> deletePokemonFromUser2(@RequestBody DeletePokemonRequest pokemon){
			return userService.deletePokemon2(pokemon.getIdPokemon());
				
	}*/

}
