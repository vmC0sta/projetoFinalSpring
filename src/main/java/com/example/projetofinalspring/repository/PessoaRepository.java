package com.example.projetofinalspring.repository;
import main.java.com.example.projetofinalspring.domain.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
