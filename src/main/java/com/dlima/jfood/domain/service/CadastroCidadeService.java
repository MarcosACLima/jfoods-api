package com.dlima.jfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dlima.jfood.domain.exception.EntidadeEmUsoException;
import com.dlima.jfood.domain.exception.EntidadeNaoEncontradaException;
import com.dlima.jfood.domain.model.Cidade;
import com.dlima.jfood.domain.model.Estado;
import com.dlima.jfood.domain.repository.CidadeRepository;
import com.dlima.jfood.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Cidade salvar(Cidade cidade) {
		// pesquisar estado
		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoRepository.buscar(estadoId);
		
		// nao existe o estado
		if (estado == null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de estado com código %d", estadoId));
		}
		
		// estado existe, settar
		cidade.setEstado(estado);
		
		return cidadeRepository.salvar(cidade);
	}

	public void excluir(Long cidadeId) {
		try {
			cidadeRepository.remover(cidadeId);
			
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de cidade com código %d", cidadeId)); 
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Cidade de código %d não pode ser removida, pois está em uso", cidadeId)); // execeção de negocio
		}
		
	}

}
