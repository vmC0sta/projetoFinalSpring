package com.example.projetofinalspring.controller.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetofinalspring.controller.Controller;
import com.example.projetofinalspring.domain.produto.UnidadeMedida;
import com.example.projetofinalspring.repository.produto.UnidadeMedidaRepository;

@RestController
@RequestMapping("elevate/categorias")
public class UnidadeMedidaController implements Controller<UnidadeMedida> {

	@Autowired
	UnidadeMedidaRepository unidadeMedidaRepository;
	
	@PostMapping("/cadastrar")
	@Override
	public ResponseEntity<UnidadeMedida> salvar(@RequestBody UnidadeMedida t) {
		unidadeMedidaRepository.save(t);
		return ResponseEntity.status(HttpStatus.CREATED).body(t);
	}

	@GetMapping("/consultar")
	@Override
	public ResponseEntity<List<UnidadeMedida>> consultar() {
		return ResponseEntity.status(HttpStatus.OK).body(unidadeMedidaRepository.findAll());
	}

	@GetMapping("/consultar/{id}")
	@Override
	public ResponseEntity<Object> consultar(@PathVariable("id") Long id) {
		Optional<UnidadeMedida> opt = unidadeMedidaRepository.findById(id);
		try {
			UnidadeMedida ct = opt.get();
			return ResponseEntity.status(HttpStatus.OK).body(ct);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("unidade de medida não encontrada");
		}
	}

	@PutMapping("/alterar/{id}")
	@Override
	public ResponseEntity<Object> alterar(@PathVariable("id") Long id, UnidadeMedida t) {
		Optional<UnidadeMedida> opt = unidadeMedidaRepository.findById(id);
		try {
			UnidadeMedida ct = opt.get();
			ct.setDescricao(t.getDescricao());
			ct.setSigla(t.getSigla());
			unidadeMedidaRepository.save(ct);
			return ResponseEntity.status(HttpStatus.OK).body(ct);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("unidade de medida não encontrada");
		}
	}

	@DeleteMapping("excluir/{id}")
	@Override
	public ResponseEntity<Object> excluir(@PathVariable("id") Long id) {
		Optional<UnidadeMedida> opt = unidadeMedidaRepository.findById(id);
		try {
			UnidadeMedida ct = opt.get();
			unidadeMedidaRepository.delete(ct);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("unidade de medida não encontrada");
		}
	}

}
