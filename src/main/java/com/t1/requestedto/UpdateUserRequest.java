package com.t1.requestedto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequest {
	
	@NotNull(message = "id is required!")
	private Long id;

	private String teamName;

	private String trainerName;

	private String rol;
	
	private String username;
	
	private String password;
}
