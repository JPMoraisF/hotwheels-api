package com.joao.hotwheelsapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joao.hotwheelsapi.domain.exception.NegocioException;
import com.joao.hotwheelsapi.domain.model.Carrinho;
import com.joao.hotwheelsapi.domain.repository.CarrinhoRepository;

@Service
public class CadastroCarrinhoService {
	
	@Autowired CarrinhoRepository carrinhoRepository;

	
	public Carrinho salvar(Carrinho carrinho) {
		return carrinhoRepository.save(carrinho);
	}
	
	public void excluir(Long carrinhoId) {
		if(carrinhoRepository.findById(carrinhoId).isEmpty()) {
			throw new NegocioException("Carrinho não encontrado!");
		}
		carrinhoRepository.deleteById(carrinhoId);
	}
}
