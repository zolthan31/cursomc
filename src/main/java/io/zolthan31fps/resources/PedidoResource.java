package io.zolthan31fps.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.zolthan31fps.domain.Pedido;
import io.zolthan31fps.services.PedidoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/pedidos")
@RequiredArgsConstructor
public class PedidoResource {
	
	private PedidoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		
		Pedido obj = service.findById(id);
		return ResponseEntity.ok().body(obj);		
		
	}

}
