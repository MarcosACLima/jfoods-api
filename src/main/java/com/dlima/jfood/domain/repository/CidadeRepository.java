package com.dlima.jfood.domain.repository;

import java.util.List;

import com.dlima.jfood.domain.model.Cidade;

public interface CidadeRepository {
	
	List<Cidade> listar();
	Cidade buscar(Long id);
	Cidade salvar(Cidade cidade);
	void remover(Cidade cidade);

}
