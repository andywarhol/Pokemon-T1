package com.t1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	@Column(name="team_name", unique=true)
	private String teamName;
	
	@Column(name="trainer_name", unique=true)
	private String trainerName;
	
	@Column(name="rol")
	private String rol;
	
	@Column(name="username", unique=true)
	private String username;
	
	@Column(name="user_password")
	private String password;
	
}

