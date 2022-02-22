package com.t1.mapper;

import org.springframework.stereotype.Component;

import com.t1.entity.UserEntity;
import com.t1.responsedto.UserResponseDTO;

@Component
public class UserMapper {

	public UserResponseDTO entityToDto(UserEntity user) {
		UserResponseDTO dto = new UserResponseDTO();
		dto.setUserName(user.getUsername());
		dto.setUserRol(user.getRol());
		dto.setUserTeamName(user.getTeamName());
		dto.setUserTrainerName(user.getTrainerName());
		return dto;
	}
}
