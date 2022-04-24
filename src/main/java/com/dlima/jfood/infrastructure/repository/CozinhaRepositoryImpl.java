package com.dlima.jfood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dlima.jfood.domain.model.Cozinha;
import com.dlima.jfood.domain.repository.CozinhaRepository;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {

	@PersistenceContext
	private EntityManager manager;
		
	@Override
	public List<Cozinha> listar() {
		return  manager.createQuery("from Cozinha", Cozinha.class).getResultList();	// JPQL	 
	}
	
	@Transactional
	@Override
	public Cozinha salvar(Cozinha cozinha) {
		return manager.merge(cozinha);
	}
	
	@Override
	public Cozinha buscar(Long id) {
		return manager.find(Cozinha.class, id);
	}
	
	@Transactional
	@Override
	public void remover(Long id) {
		Cozinha cozinha = buscar(id);
		
		if (cozinha == null) {
			throw new EmptyResultDataAccessException(1); // exececao para quando nao encontra resultado
		}
		
		manager.remove(cozinha);
	}

}
