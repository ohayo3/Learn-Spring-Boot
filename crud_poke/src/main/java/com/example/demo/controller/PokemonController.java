package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Pokemon;
import com.example.demo.repository.PokemonRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PokemonController {

	// レポジトリを初期化
	private final PokemonRepository repository;
	
	@GetMapping("/")
	// DBのポケモンを全て取得
	public String showPokemonList(Model model) {
		model.addAttribute("pokemons", repository.findAll());
		return "index";
	}
	
	@GetMapping("/add")
	// 登録フォームのポケモンをDBに追加
	public String addPokemon(@ModelAttribute Pokemon pokemon) {
		return "form";
	}
	
	@PostMapping("/process")
	public String processPokemon(@Validated @ModelAttribute Pokemon pokemon, BindingResult result) {
		if(result.hasErrors()) {
			return "form";
		}
		
		repository.save(pokemon);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	// 特定IDのポケモンの項目を更新する
	public String editPokemon(@PathVariable Long id, Model model) {
		model.addAttribute("pokemon", repository.findById(id));
		return "form";
	}
	
	@GetMapping("/delete/{id}")
	// 特定IDのポケモンを削除する
	public String deletePokemon(@PathVariable Long id) {
		repository.deleteById(id);
		return "redirect:/";
	}
}
