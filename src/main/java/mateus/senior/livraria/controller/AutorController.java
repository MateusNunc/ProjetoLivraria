package mateus.senior.livraria.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import mateus.senior.livraria.dto.AutorDTO;
import mateus.senior.livraria.mapper.AutorMapper;
import mateus.senior.livraria.model.entity.AutorEntity;
import mateus.senior.livraria.model.service.AutorService;

/**
 * 
 * @author Mateus.Nascimento
 *
 */
@Controller
@RequestMapping(path = "/api/autor")
public class AutorController {

	@Autowired
	private AutorService service;

	@Autowired
	private AutorMapper mapper;

	@PostMapping(path = "/add/")
	public ResponseEntity<AutorDTO> cadastrarAutor(@RequestBody AutorDTO autorDto) {
		AutorEntity autor = mapper.toEntity(autorDto);
		return ResponseEntity.ok().body(mapper.toDTO(service.createAutor(autor)));
	}

	@PutMapping(path = "/atualizar/{codigo}")
	public ResponseEntity<AutorDTO> atualizarAutor(@PathVariable String codigo, @RequestBody AutorDTO autorDto) {
		UUID idAutor = UUID.fromString(codigo);
		AutorEntity autor = mapper.toEntity(autorDto);
		AutorDTO body = mapper.toDTO(service.updateAutor(idAutor, autor));
		return ResponseEntity.ok().body(body);
	}

	@GetMapping(path = "/autor")
	public ResponseEntity<List<AutorDTO>> findAll() {
		List<AutorDTO> autoresDtos = service.getAllAutores().stream().map(e -> mapper.toDTO(e))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(autoresDtos);
	}

	@DeleteMapping(path = "deletarAutor/{codigo}")
	public ResponseEntity<Void> delete(@PathVariable String codigo) {
		UUID idAutor = UUID.fromString(codigo);
		service.deleteAutor(idAutor);

		return ResponseEntity.ok().build();
	}
}
