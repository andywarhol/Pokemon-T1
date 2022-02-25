package com.t1.requestedto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InsertPokemonRequest {

	private List<CreatePokemonRequest> pokemons;
}
