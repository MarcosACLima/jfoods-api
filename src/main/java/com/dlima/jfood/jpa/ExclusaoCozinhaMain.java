package com.dlima.jfood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.dlima.jfood.JfoodApiApplication;
import com.dlima.jfood.domain.model.Cozinha;
import com.dlima.jfood.domain.repository.CozinhaRepository;

public class ExclusaoCozinhaMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(JfoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		// Instancia de Cadastro Cozinha
		CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);

		Cozinha cozinha = new Cozinha();
		cozinha.setId(1L);
		
		cozinhas.remover(cozinha.getId());
		
	}

}
