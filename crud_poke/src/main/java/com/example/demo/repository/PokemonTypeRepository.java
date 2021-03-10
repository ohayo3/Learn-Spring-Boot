package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.PokemonType;

public interface PokemonTypeRepository extends JpaRepository<PokemonType, Long> {

}
