package com.dlima.jfood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlima.jfood.domain.exception.EntidadeNaoEncontradaException;
import com.dlima.jfood.domain.model.Restaurante;
import com.dlima.jfood.domain.repository.RestauranteRepository;
import com.dlima.jfood.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CadastroRestauranteService cadastroRestauranteService;
	
	@GetMapping
	public List<Restaurante> listar() {
		return restauranteRepository.listar();
	}
	
	@GetMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> buscar(@PathVariable Long restauranteId) {
		Restaurante restaurante = restauranteRepository.buscar(restauranteId);
		
		if (restaurante != null) {
			return ResponseEntity.ok(restaurante); // 200
		}
		
		return ResponseEntity.notFound().build(); // 404
	}
	
	@PostMapping
	public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante) {
		try {
			restaurante = cadastroRestauranteService.salvar(restaurante);
			
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(restaurante);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage()); // retornar mensagem que nao existe id de cozinha informado
 		}
	}
	
	/* challenge */
	@PutMapping("/{restauranteId}")
	public ResponseEntity<?> atualizar(@PathVariable Long restauranteId, @RequestBody Restaurante restaurante) {
		// Obs: necessario try / catch para EntidadeNaoEncontrada lancado BadResquest 
		try {
			// Buscar Objeto
			Restaurante restauranteAtual = restauranteRepository.buscar(restauranteId);
			
			// Caso objeto encontrado
			if (restauranteAtual != null) {
				BeanUtils.copyProperties(restaurante, restauranteAtual, "id"); // ignorar ID ao salvar
				
				restauranteAtual = cadastroRestauranteService.salvar(restauranteAtual);
				return ResponseEntity.ok(restauranteAtual); // response 200 com body
			}
			
			// Caso nao exista o objeto/id informando - 404
			return ResponseEntity.notFound().build();
			
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
}
