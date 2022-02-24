package com.t1.requestedto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DeletePokemonRequest {

	private Long idUser;
	private Long idPokemon;
}
