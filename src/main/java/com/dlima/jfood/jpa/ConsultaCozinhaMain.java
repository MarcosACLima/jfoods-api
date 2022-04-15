package com.dlima.jfood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.dlima.jfood.JfoodApiApplication;
import com.dlima.jfood.domain.model.Restaurante;
import com.dlima.jfood.domain.repository.RestauranteRepository;

public class ConsultaCozinhaMain {

	public static void main(String[] args) {
		// Rodar como aplicação Java, nao web
		ApplicationContext applicationContext = new SpringApplicationBuilder(JfoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		// Instancia de Cadastro Restaurante
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);

		List<Restaurante> todasRestaurantes = restauranteRepository.listar();

		for (Restaurante restaurante : todasRestaurantes) {
			System.out.printf("%s - %f - %s \n", 
					restaurante.getNome(), restaurante.getTaxaFrete(), restaurante.getCozinha().getNome());
		}

	}

}
