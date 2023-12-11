package com.example.projetofinalspring.controller.endereco;

import com.example.projetofinalspring.controller.Controller;
import com.example.projetofinalspring.domain.endereco.Estado;
import com.example.projetofinalspring.domain.endereco.Pais;
import com.example.projetofinalspring.repository.endereco.EstadoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/elevate/estado")
public class EstadoController implements Controller<Estado> {
    EstadoRepository estadoRepository;

    public EstadoController(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @PostMapping("/cadastrar")
    @Override
    public ResponseEntity<Estado> salvar(@RequestBody Estado estado) {
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoRepository.save(estado));
    }

    @GetMapping("/consultar")
    @Override
    public ResponseEntity<List<Estado>> consultar() {
        return ResponseEntity.status(HttpStatus.OK).body(estadoRepository.findAll());
    }

    @GetMapping("/consultar/{id}")
    @Override
    public ResponseEntity<Object> consultar(@PathVariable("id") Long id) {
        Optional<Estado> optionalEstado = estadoRepository.findById(id);
        try {
            Estado estado = optionalEstado.get();
            return ResponseEntity.status(HttpStatus.OK).body(estado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estado não encontrado");
        }
    }

    @PutMapping("/alterar/{id}")
    @Override
    public ResponseEntity<Object> alterar(@PathVariable("id") Long id, @RequestBody Estado estado) {
        Optional<Estado> optionalEstado = estadoRepository.findById(id);
        try {
            Estado estadoX = optionalEstado.get();
            estadoX.setDescricao(estado.getDescricao());

            Pais pais = new Pais();
            pais.setId(estado.getPais().getId());
            pais.setDescricao(estado.getPais().getDescricao());

            estadoX.setPais(pais);
            estadoRepository.save(estadoX);
            return ResponseEntity.status(HttpStatus.OK).body(estadoX);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estado não encontrado");
        }
    }

    @DeleteMapping("/excluir/{id}")
    @Override
    public ResponseEntity<Object> excluir(@PathVariable("id") Long id) {
        Optional<Estado> optionalEstado = estadoRepository.findById(id);
        try {
            Estado estado = optionalEstado.get();
            estadoRepository.delete(estado);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estado não encontrado");
        }
    }
}
