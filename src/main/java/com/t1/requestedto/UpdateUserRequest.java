package com.t1.requestedto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequest {

	private Long id; 
	
	private String teamName;
	
	private String trainerName;
	
	private String rol; 
	
	private String password;
	
	private List<CreatePokemonRequest> pokemons;
}
