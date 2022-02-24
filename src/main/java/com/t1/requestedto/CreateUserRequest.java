package com.t1.requestedto;


import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateUserRequest {
	@NotBlank(message = "Team name is required!")
	@NotNull(message = "Team name is required!")
	private String teamName;
	@NotBlank(message = "Trainer name is required!")
	@NotNull(message = "Trainer name is required!")
	private String trainerName;
	@NotNull(message = "Role is required!")
	@NotBlank(message = "Role is required!")
	private String rol;
	@NotNull(message = "Username is required!")
	@NotBlank(message = "Username is required!")
	private String username;
	@NotNull(message = "Password is required!")
	@NotBlank(message = "Password is required!")
	private String password;
	
	
	private List<CreatePokemonRequest> pokemons;
	
}
