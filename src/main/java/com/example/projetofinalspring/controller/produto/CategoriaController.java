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
import com.example.projetofinalspring.domain.produto.Categoria;
import com.example.projetofinalspring.repository.produto.CategoriaRepository;

@RestController
@RequestMapping("elevate/categorias")
public class CategoriaController implements Controller<Categoria> {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@PostMapping("/cadastrar")
	@Override
	public ResponseEntity<Categoria> salvar(@RequestBody Categoria t) {
		categoriaRepository.save(t);
		return ResponseEntity.status(HttpStatus.CREATED).body(t);
	}

	@GetMapping("/consultar")
	@Override
	public ResponseEntity<List<Categoria>> consultar() {
		return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.findAll());
	}

	@GetMapping("/consultar/{id}")
	@Override
	public ResponseEntity<Object> consultar(@PathVariable("id") Long id) {
		Optional<Categoria> opt = categoriaRepository.findById(id);
		try {
			Categoria ct = opt.get();
			return ResponseEntity.status(HttpStatus.OK).body(ct);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("categoria não encontrada");
		}
	}

	@PutMapping("/alterar/{id}")
	@Override
	public ResponseEntity<Object> alterar(@PathVariable("id") Long id, Categoria t) {
		Optional<Categoria> opt = categoriaRepository.findById(id);
		try {
			Categoria ct = opt.get();
			ct.setDescricao(t.getDescricao());
			categoriaRepository.save(ct);
			return ResponseEntity.status(HttpStatus.OK).body(ct);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("categoria não encontrada");
		}
	}

	@DeleteMapping("excluir/{id}")
	@Override
	public ResponseEntity<Object> excluir(@PathVariable("id") Long id) {
		Optional<Categoria> opt = categoriaRepository.findById(id);
		try {
			Categoria ct = opt.get();
			categoriaRepository.delete(ct);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("categoria não encontrada");
		}
	}

}
