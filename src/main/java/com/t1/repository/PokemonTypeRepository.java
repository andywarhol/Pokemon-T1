package com.t1.repository;

import org.springframework.stereotype.Repository;

import com.t1.entity.PokemonEntity;
import com.t1.entity.PokemonTypeEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PokemonTypeRepository extends JpaRepository<PokemonTypeEntity,Long> {

}
