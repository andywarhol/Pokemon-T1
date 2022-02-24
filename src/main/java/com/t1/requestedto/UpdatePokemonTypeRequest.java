package com.t1.requestedto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdatePokemonTypeRequest {

	private Long idType; 
	
	private String pkmType;
}
