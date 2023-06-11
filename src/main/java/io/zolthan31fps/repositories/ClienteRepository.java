package io.zolthan31fps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.zolthan31fps.domain.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {	

}
