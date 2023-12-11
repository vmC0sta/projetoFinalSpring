package com.example.projetofinalspring.controller.endereco;

import com.example.projetofinalspring.controller.Controller;
import com.example.projetofinalspring.domain.endereco.Municipio;
import com.example.projetofinalspring.repository.endereco.MunicipioRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class MunicipioController implements Controller<Municipio> {
    MunicipioRepository municipioRepository;
    public MunicipioController(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }

    @Override
    public ResponseEntity<Municipio> salvar(Municipio municipio) {
        return null;
    }

    @Override
    public ResponseEntity<List<Municipio>> consultar() {
        return null;
    }

    @Override
    public ResponseEntity<Object> consultar(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Object> alterar(Long id, Municipio municipio) {
        return null;
    }

    @Override
    public ResponseEntity<Object> excluir(Long id) {
        return null;
    }
}
