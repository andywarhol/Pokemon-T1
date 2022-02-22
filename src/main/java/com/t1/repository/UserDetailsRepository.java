package com.t1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.t1.entity.UserEntity;

public interface UserDetailsRepository extends JpaRepository<UserEntity, Long>{

	UserEntity findByUserName(String userName);
}
