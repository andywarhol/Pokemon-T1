package com.t1.responsedto;

import com.t1.entity.UserEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserResponse {
 	
	private Long id;

	private String teamName;
	
	private String trainerName;

	private String rol;

	private String username;
	
	private String password;
	
	public UserResponse(UserEntity userEntity) {
		this.id = userEntity.getId();
		this.teamName = userEntity.getTeamName();
		this.trainerName = userEntity.getTrainerName();
		this.rol = userEntity.getRol();
		this.username = userEntity.getUsername();
		this.password = userEntity.getPassword();
	}
	
}
