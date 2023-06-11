package io.zolthan31fps.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import io.zolthan31fps.domain.Categoria;
import io.zolthan31fps.repositories.CategoriaRepository;
import io.zolthan31fps.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaService {
	
	
	private CategoriaRepository repository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())); 
				
	}

}
