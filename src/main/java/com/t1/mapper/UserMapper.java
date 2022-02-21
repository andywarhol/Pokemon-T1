package com.t1.mapper;

import org.springframework.stereotype.Component;

import com.t1.entity.UserEntity;
import com.t1.responsedto.UserResponseDTO;

@Component
public class UserMapper {

	public UserResponseDTO entityToDto(UserEntity user) {
		UserResponseDTO dto = new UserResponseDTO();
		dto.setUserName(user.getUserName());
		dto.setUserRol(user.getUserRol());
		dto.setUserTeamName(user.getUserTeamName());
		dto.setUserTrainerName(user.getUserTrainerName());
		return dto;
	}
}
