package io.zolthan31fps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.zolthan31fps.domain.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Integer> {	

}
