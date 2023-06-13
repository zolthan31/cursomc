package io.zolthan31fps.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import io.zolthan31fps.domain.Pedido;
import io.zolthan31fps.repositories.PedidoRepository;
import io.zolthan31fps.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {
	
private PedidoRepository repository;
	
	public Pedido findById(Integer id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName())); 
				
	}

}
