package com.t1.requestedto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InsertPokemonRequest {

	private String pkmName;
	
	private String types; 
}
