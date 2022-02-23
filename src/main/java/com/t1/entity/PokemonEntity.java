package com.t1.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="pokemon_teams")
@AllArgsConstructor
@NoArgsConstructor
public class PokemonEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pkm_id")
	private Long id;
	
	@Column(name="pkm_name")
	private String pkmName;
	
	@ManyToOne
	@JoinColumn(name = "pkm_team")
	private UserEntity user;
	
	@OneToMany(mappedBy = "pkm")
	private List<PokemonTypeEntity> types;
}
