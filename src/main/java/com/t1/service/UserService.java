package com.t1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t1.entity.PokemonEntity;
import com.t1.entity.UserEntity;
import com.t1.repository.PokemonRepository;
import com.t1.repository.UserRepository;
import com.t1.requestedto.CreatePokemonRequest;
import com.t1.requestedto.CreateUserRequest;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PokemonRepository pokemonRepository;
	
	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}
	
	public UserEntity createUser(CreateUserRequest createUserRequest) {
		UserEntity user = new UserEntity(createUserRequest);
		
		user = userRepository.save(user);
		
		List<PokemonEntity> pokemonList = new ArrayList<PokemonEntity>();
		
		if (createUserRequest.getPokemons() != null) {
			
			for(CreatePokemonRequest createPokemonRequest : createUserRequest.getPokemons()) {
				PokemonEntity pokemon = new PokemonEntity();
				pokemon.setPkmName(createPokemonRequest.getPkmName());
				pokemon.setUser(user);
				
				pokemonList.add(pokemon);
			}
			
			pokemonRepository.saveAll(pokemonList);
		}
		
		user.setPkmTeam(pokemonList);
		
		return user;
	}
	
}

