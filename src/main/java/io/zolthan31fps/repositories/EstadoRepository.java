package io.zolthan31fps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.zolthan31fps.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {	

}
