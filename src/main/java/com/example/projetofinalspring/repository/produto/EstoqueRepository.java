package com.example.projetofinalspring.repository.produto;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projetofinalspring.domain.produto.Estoque;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long>{

}