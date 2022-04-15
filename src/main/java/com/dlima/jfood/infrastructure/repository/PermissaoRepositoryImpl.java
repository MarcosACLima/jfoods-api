package com.dlima.jfood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dlima.jfood.domain.model.Permissao;
import com.dlima.jfood.domain.repository.PermissaoRepository;

@Component
public class PermissaoRepositoryImpl implements PermissaoRepository {

	@PersistenceContext
	private EntityManager manager;
		
	@Override
	public List<Permissao> listar() {
		return  manager.createQuery("from Permissao", Permissao.class).getResultList();	// JPQL	 
	}
	
	@Transactional
	@Override
	public Permissao salvar(Permissao permissao) {
		return manager.merge(permissao);
	}
	
	@Override
	public Permissao buscar(Long id) {
		return manager.find(Permissao.class, id);
	}
	
	@Transactional
	@Override
	public void remover(Permissao permissao) {
		permissao = buscar(permissao.getId());
		manager.remove(permissao);
	}

}
