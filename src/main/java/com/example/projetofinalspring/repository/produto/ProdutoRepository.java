package com.example.projetofinalspring.repository.produto;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projetofinalspring.domain.produto.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}