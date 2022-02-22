package com.t1.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.t1.requestedto.CreateUserRequest;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="users")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	
	@Column(name="team_name",length = 30, unique=true)
	private String teamName;
	
	@Column(name="trainer_name", length = 30, unique=true)
	private String trainerName;
	
	@Column(name="rol")
	private String rol;
	
	@Column(name="username", length = 30, unique=true)
	private String username;
	
	@Column(name="user_password")
	private String password;

	//@OneToMany (mappedBy = "user")
	//@JoinColumn(name="user_id")
	//private List<PokemonEntity> pkmTeam;
	
	public UserEntity(CreateUserRequest createUserRequest) {
		this.teamName = createUserRequest.getTeamName();
		this.trainerName = createUserRequest.getTrainerName();
		this.rol = createUserRequest.getRol();
		this.username = createUserRequest.getUsername();
		this.password = createUserRequest.getPassword();
	}
	
}
