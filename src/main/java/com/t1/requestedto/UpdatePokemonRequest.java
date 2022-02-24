package com.t1.requestedto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdatePokemonRequest {

	private Long id; 
	
	private String pkmName;
	
	private UpdatePokemonTypeRequest updatePkmTypes;
	
	//private List<UpdatePokemonTypeRequest> types;
}
