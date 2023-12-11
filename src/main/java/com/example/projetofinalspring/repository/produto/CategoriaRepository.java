package com.example.projetofinalspring.repository.produto;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projetofinalspring.domain.produto.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
