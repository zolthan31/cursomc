package io.zolthan31fps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.zolthan31fps.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {	

}
