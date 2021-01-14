package com.joao.hotwheelsapi.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joao.hotwheelsapi.domain.model.Carrinho;
import com.joao.hotwheelsapi.domain.repository.CarrinhoRepository;
import com.joao.hotwheelsapi.domain.service.CadastroCarrinhoService;

@RestController
@RequestMapping("api/carrinho")
public class CarrinhoController {

	@Autowired CarrinhoRepository carrinhoRepository;
	
	@Autowired CadastroCarrinhoService carrinhoService;
	
	@GetMapping
	public List<Carrinho> buscar(){
		return carrinhoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Carrinho> buscarUnico(@PathVariable Long id) {
		Optional<Carrinho> carrinho = carrinhoRepository.findById(id);
		
		if(carrinho.isPresent()) {
			
			return ResponseEntity.ok(carrinho.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
		
	@PostMapping
	public Carrinho adicionar(@RequestBody Carrinho carrinho){
		return carrinhoRepository.save(carrinho);
	}
	
	@DeleteMapping("/{carrinhoId}")
	public ResponseEntity<Carrinho> remover (@PathVariable Long carrinhoId) {
		if(!carrinhoRepository.existsById(carrinhoId)) {
			return ResponseEntity.notFound().build();
		}
		carrinhoService.excluir(carrinhoId);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{carrinhoId}")
	public ResponseEntity<Carrinho> atualizar(@PathVariable Long carrinhoId, 
			@RequestBody Carrinho carrinho){
		if(!carrinhoRepository.existsById(carrinhoId)) {
			return ResponseEntity.notFound().build();
		}
		carrinho.setId(carrinhoId);
		carrinhoService.salvar(carrinho);
		return ResponseEntity.ok(carrinho);
	}
	
	
	
	
}
