package io.zolthan31fps.resources;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.zolthan31fps.domain.Cliente;
import io.zolthan31fps.services.ClienteService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping(value= "/clientes")
@RequiredArgsConstructor
public class ClienteResource {
	
	
	private ClienteService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		
		Cliente obj = service.findById(id);
		return ResponseEntity.ok().body(obj);		
		
	}

}
