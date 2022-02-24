package com.t1.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="pokemon_teams")
@AllArgsConstructor
@NoArgsConstructor
public class PokemonEntity {

	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pkm_id")
	private Long id;*/
	
	@EmbeddedId
	private Composite composite;
	
	@Column(name="pkm_type")
	private String type; 
	
	/*@ManyToOne
	@JoinColumn(name = "pkm_team")
	private UserEntity user;*/
	

	
}
