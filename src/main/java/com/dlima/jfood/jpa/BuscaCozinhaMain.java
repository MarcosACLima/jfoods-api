package com.dlima.jfood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.dlima.jfood.JfoodApiApplication;
import com.dlima.jfood.domain.model.Cozinha;
import com.dlima.jfood.domain.repository.CozinhaRepository;

public class BuscaCozinhaMain {

	public static void main(String[] args) {
		// Rodar como aplicação Java, nao web
		ApplicationContext applicationContext = new SpringApplicationBuilder(JfoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		// Instancia de Cadastro Cozinha
		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);

		Cozinha cozinha = cozinhaRepository.porId(1L);
		
		System.out.println(cozinha.getNome());
		
	}

}
