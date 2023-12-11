package com.example.projetofinalspring.controller.endereco;

import com.example.projetofinalspring.controller.Controller;
import com.example.projetofinalspring.domain.endereco.Pais;
import com.example.projetofinalspring.repository.PaisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/consultar/{id}")
    @Override
    public ResponseEntity<Object> consultar(@PathVariable("id") Long id) {
        Optional<Pais> optionalPais = paisRepository.findById(id);
        try{
            Pais pais = optionalPais.get();
            return ResponseEntity.status(HttpStatus.OK).body(pais);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pais não encontrado");
        }
    }

    @PutMapping("/alterar/{id}")
    @Override
    public ResponseEntity<Object> alterar(@PathVariable("id") Long id, @RequestBody Pais pais) {
        Optional<Pais> optionalPais = paisRepository.findById(id);
        try{
            Pais paisX = optionalPais.get();
            paisX.setDescricao(pais.getDescricao());
            paisRepository.save(paisX);
            return ResponseEntity.status(HttpStatus.OK).body(paisX);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("País não encontrado");
        }
    }

    @DeleteMapping("excluir/{id}")
    @Override
    public ResponseEntity<Object> excluir(@PathVariable("id") Long id) {
        Optional<Pais> optionalPais = paisRepository.findById(id);
        try {
            Pais pais = optionalPais.get();
            paisRepository.delete(pais);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("País não encontrado");
        }
    }
}
