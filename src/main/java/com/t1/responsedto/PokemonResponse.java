package com.t1.responsedto;

import com.t1.entity.PokemonEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonResponse {
	private String pkmName;
	private String type;
	
	
	public PokemonResponse(PokemonEntity pkmEntity) {
		this.pkmName = pkmEntity.getComposite().getPkmName();
		this.type = pkmEntity.getType();
	}

}
