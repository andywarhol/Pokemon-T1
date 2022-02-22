package com.t1.requestedto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePokemonRequest {
	
	private String pkmName;
	
	private List<CreatePokemonTypeRequest> types;

}
