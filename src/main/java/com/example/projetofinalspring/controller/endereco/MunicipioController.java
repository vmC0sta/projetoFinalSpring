package com.example.projetofinalspring.controller.endereco;

import com.example.projetofinalspring.controller.Controller;
import com.example.projetofinalspring.domain.endereco.Estado;
import com.example.projetofinalspring.domain.endereco.Municipio;
import com.example.projetofinalspring.repository.endereco.MunicipioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("elevate/municipio")
public class MunicipioController implements Controller<Municipio> {
    MunicipioRepository municipioRepository;
    public MunicipioController(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }
    @PostMapping("/cadastrar")
    @Override
    public ResponseEntity<Municipio> salvar(@RequestBody Municipio municipio) {
        return ResponseEntity.status(HttpStatus.CREATED).body(municipioRepository.save(municipio));
    }
    @GetMapping("/consultar")
    @Override
    public ResponseEntity<List<Municipio>> consultar() {
        return ResponseEntity.status(HttpStatus.OK).body(municipioRepository.findAll());
    }

    @GetMapping("/consultar/{id}")
    @Override
    public ResponseEntity<Object> consultar(@PathVariable("id") Long id) {
        Optional<Municipio> optionalMunicipio = municipioRepository.findById(id);
        try{
            Municipio municipio = optionalMunicipio.get();
            return ResponseEntity.status(HttpStatus.OK).body(municipio);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Município não encontrado");
        }
    }

    @PutMapping("/alterar/{id}")
    @Override
    public ResponseEntity<Object> alterar(@PathVariable("id") Long id, @RequestBody Municipio municipio) {
        Optional<Municipio> optionalMunicipio = municipioRepository.findById(id);
        try{
            Municipio municipioX = optionalMunicipio.get();
            municipioX.setDescricao(municipio.getDescricao());
            municipioX.setEstado(municipio.getEstado());
            municipioRepository.save(municipioX);
            return ResponseEntity.status(HttpStatus.OK).body(municipioX);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Município não encontrado");
        }
    }
    @DeleteMapping("/excluir/{id}")
    @Override
    public ResponseEntity<Object> excluir(@PathVariable("id") Long id) {
        Optional<Municipio> optionalMunicipio = municipioRepository.findById(id);
        try {
            Municipio municipio = optionalMunicipio.get();
            municipioRepository.delete(municipio);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Município não encontrado");
        }
    }
}
