package com.dlima.jfood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dlima.jfood.domain.model.Cidade;
import com.dlima.jfood.domain.repository.CidadeRepository;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {

	@PersistenceContext
	private EntityManager manager;
		
	@Override
	public List<Cidade> listar() {
		return  manager.createQuery("from Cidade", Cidade.class).getResultList();	// JPQL	 
	}
	
	@Transactional
	@Override
	public Cidade salvar(Cidade cidade) {
		return manager.merge(cidade);
	}
	
	@Override
	public Cidade buscar(Long id) {
		return manager.find(Cidade.class, id);
	}
	
	@Transactional
	@Override
	public void remover(Cidade cidade) {
		cidade = buscar(cidade.getId());
		manager.remove(cidade);
	}

}
