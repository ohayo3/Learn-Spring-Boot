package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

}
