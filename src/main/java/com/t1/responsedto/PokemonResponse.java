package com.t1.responsedto;

import com.t1.entity.PokemonEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonResponse {
		
	private String type;
	
	public PokemonResponse(PokemonEntity pkmEntity) {
		this.type = pkmEntity.getType();
	}

}
