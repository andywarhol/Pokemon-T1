package com.t1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t1.entity.PokemonEntity;

@Repository
public interface PokemonRepository extends JpaRepository<PokemonEntity, Long>{

}
