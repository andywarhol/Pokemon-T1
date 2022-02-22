package com.t1.responsedto;

import com.t1.entity.PokemonTypeEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonTypeResponse {
	
	private Long id;
	
	private String pkmType;
	
	public PokemonTypeResponse(PokemonTypeEntity pokemonTypeEntity) {
		
		this.id = pokemonTypeEntity.getId();
		this.pkmType = pokemonTypeEntity.getPkmType();
	}

}
