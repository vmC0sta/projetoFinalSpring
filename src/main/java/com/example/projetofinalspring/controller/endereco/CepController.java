package com.example.projetofinalspring.controller.endereco;

import com.example.projetofinalspring.controller.Controller;
import com.example.projetofinalspring.domain.endereco.Cep;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class CepController implements Controller<Cep> {

    @Override
    public ResponseEntity<Cep> salvar(Cep cep) {
        return null;
    }

    @Override
    public ResponseEntity<List<Cep>> consultar() {
        return null;
    }

    @Override
    public ResponseEntity<Object> consultar(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Object> alterar(Long id, Cep cep) {
        return null;
    }

    @Override
    public ResponseEntity<Object> excluir(Long id) {
        return null;
    }
}
