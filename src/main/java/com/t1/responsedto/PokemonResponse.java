package com.t1.responsedto;

import java.util.List;

import com.t1.entity.PokemonEntity;
import com.t1.entity.PokemonTypeEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonResponse {
	
	private Long id;
	
	private String pkmName;
	
	//
	private List<PokemonTypeEntity> types;
	
	public PokemonResponse(PokemonEntity pkmEntity) {
		this.id = pkmEntity.getId();
		this.pkmName = pkmEntity.getPkmName();
		//
		this.types = pkmEntity.getTypes();
		
	}
}
