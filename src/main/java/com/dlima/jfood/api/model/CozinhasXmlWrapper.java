package com.dlima.jfood.api.model;

import java.util.List;

import com.dlima.jfood.domain.model.Cozinha;

import lombok.Data;
import lombok.NonNull;

@Data
public class CozinhasXmlWrapper {
	
	@NonNull
	private List<Cozinha> cozinhas;
	
}
