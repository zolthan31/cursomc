package io.zolthan31fps.resources;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.zolthan31fps.domain.Categoria;
import io.zolthan31fps.services.CategoriaService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping(value= "/categorias")
@RequiredArgsConstructor
public class CategoriaResource {
	
	
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		
		Categoria obj = service.findById(id);
		return ResponseEntity.ok().body(obj);		
		
	}

}
