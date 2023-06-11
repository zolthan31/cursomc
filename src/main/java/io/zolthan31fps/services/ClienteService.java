package io.zolthan31fps.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import io.zolthan31fps.domain.Cliente;
import io.zolthan31fps.repositories.ClienteRepository;
import io.zolthan31fps.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
	
	
	private ClienteRepository repository;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())); 
				
	}

}
