package com.t1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t1.entity.Composite;
import com.t1.entity.PokemonEntity;
import com.t1.entity.UserEntity;
import com.t1.repository.PokemonRepository;
import com.t1.repository.UserRepository;
import com.t1.requestedto.CreatePokemonRequest;
import com.t1.requestedto.CreateUserRequest;
import com.t1.requestedto.DeleteRequest;
import com.t1.requestedto.InsertPokemonRequest;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PokemonRepository pokemonRepository;
	
	public UserEntity createUser(CreateUserRequest createUserRequest) {

		UserEntity user = new UserEntity(createUserRequest);

		user.setPkmTeam(new ArrayList<PokemonEntity>());

		if (createUserRequest.getPokemons() != null) {
			for(CreatePokemonRequest createPkm : createUserRequest.getPokemons()) {
				PokemonEntity pokemon = new PokemonEntity();
			
				Composite composite = new Composite(); 
				composite.setUsername(createUserRequest.getUsername());
				composite.setPkmName(createPkm.getPkmName());
				
				pokemon.setComposite(composite);
				pokemon.setType(createPkm.getTypes());
				
				user.getPkmTeam().add(pokemon);
			}	
			
			userRepository.save(user);
		}

		return user;
	}

	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}
	
	public List<UserEntity> getByUser(String username){
		return userRepository.findByUsername(username);
	}
	
	public String deletePokemon(DeleteRequest deleteRequest) {
		Composite composite = new Composite(); 
		
		composite.setUsername(deleteRequest.getUsername());
		composite.setPkmName(deleteRequest.getPkmName());
		
		pokemonRepository.deleteById(composite);
		
		return "Pokemon Deleted";
	}
	
	public UserEntity insertPokemon(String username, InsertPokemonRequest insertPokemonRequest) {
				
		UserEntity user = userRepository.getByUsername(username); 

		if (insertPokemonRequest.getPokemons() != null && !insertPokemonRequest.getPokemons().isEmpty()) {
			for(CreatePokemonRequest createPkm : insertPokemonRequest.getPokemons()) {
				PokemonEntity pokemon = new PokemonEntity();
				Composite composite = new Composite(); 
				
				composite.setUsername(user.getUsername());
				composite.setPkmName(createPkm.getPkmName());
				
				pokemon.setComposite(composite);
				pokemon.setType(createPkm.getTypes());
				
				user.getPkmTeam().add(pokemon);
			}	
			
			userRepository.save(user);
		}

		return user;
	}
	
}
