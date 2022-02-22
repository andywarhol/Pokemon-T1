package com.t1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t1.entity.PokemonTypeEntity;

@Repository
public interface PokemonTypeRepository extends JpaRepository <PokemonTypeEntity, Long> {

}
