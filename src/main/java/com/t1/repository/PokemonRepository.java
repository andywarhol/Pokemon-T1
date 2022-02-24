package com.t1.repository;

import org.springframework.stereotype.Repository;

import com.t1.entity.PokemonEntity;
import com.t1.entity.UserEntity;

import java.util.List;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PokemonRepository extends JpaRepository<PokemonEntity,Long> {
	
}
