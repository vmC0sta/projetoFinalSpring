package com.example.projetofinalspring.controller.endereco;

import com.example.projetofinalspring.controller.Controller;
import com.example.projetofinalspring.domain.endereco.Pais;
import com.example.projetofinalspring.repository.PaisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("elevate/pais")
public class PaisController implements Controller<Pais> {
    PaisRepository paisRepository;

    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PostMapping("/cadastrar")
    @Override
    public ResponseEntity<Pais> salvar(@RequestBody Pais pais) {
        paisRepository.save(pais);
        return ResponseEntity.status(HttpStatus.CREATED).body(pais);
    }

    @GetMapping("/consultar")
    @Override
    public ResponseEntity<List<Pais>> consultar() {
        return ResponseEntity.status(HttpStatus.OK).body(paisRepository.findAll());
    }

    @Override
    public ResponseEntity<Object> consultar(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Object> alterar(Long id, Pais pais) {
        return null;
    }

    @Override
    public ResponseEntity<Object> excluir(Long id) {
        return null;
    }
}
