package com.joao.hotwheelsapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joao.hotwheelsapi.domain.model.Carrinho;
import com.joao.hotwheelsapi.domain.repository.CarrinhoRepository;

@RestController
@RequestMapping("api/carrinho")
public class CarrinhoController {

	@Autowired CarrinhoRepository carrinhoRepository;
	
	@GetMapping
	public List<Carrinho> buscar(){
		return carrinhoRepository.findAll();
	}
	
	@PostMapping
	public Carrinho adicionar(@RequestBody Carrinho carrinho){
		
		return carrinhoRepository.save(carrinho);
	}
	
}