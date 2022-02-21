package com.t1.responsedto;

import com.t1.entity.PokemonEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonResponse {
	
	private Long id;
	
	private String pkmName;
	
	public PokemonResponse(PokemonEntity pkmEntity) {
		this.id = pkmEntity.getId();
		this.pkmName = pkmEntity.getPkmName();
	}

}
