package com.t1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="users")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="user_name", length=30, unique=true)
	private String userName;
	
	@Column(name="user_pass", length=30)
	private String userPass;
	
	@Column(name="user_teamName")
	private String userTeamName;
	
	@Column(name="user_trainerName", length=30, unique=true)
	private String userTrainerName;
	
	@Column(name="user_rol")
	private String userRol;
	
	
}

