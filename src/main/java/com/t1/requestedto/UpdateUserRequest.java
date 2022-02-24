package com.t1.requestedto;


import java.util.List;

import javax.validation.constraints.NotNull;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequest {

	@NotNull(message = "id is required!")
	private Long id;

	private String teamName;

	private String trainerName;

	private String rol;
	
	private String username;
	
	private String password;
  	
	private List<CreatePokemonRequest> pokemons;


}
