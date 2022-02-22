package com.t1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="pokemon_types")
@Entity
public class PokemonTypeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_type")
	private Long id;

	@Column(name="name_type")
	private String pkmType;
	
	//@ManyToOne
	//@JoinColumn(name = "pkm_type_id")
	//private PokemonEntity pkm;
	
	

}
