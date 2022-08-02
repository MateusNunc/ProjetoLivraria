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

import mateus.senior.livraria.dto.LivroDTO;
import mateus.senior.livraria.mapper.LivroMapper;
import mateus.senior.livraria.model.entity.LivroEntity;
import mateus.senior.livraria.model.service.LivroService;

/**
 * 
 * @author Mateus.Nascimento
 *
 */
@Controller
@RequestMapping(path = "/api/livro")
public class LivroController {

	@Autowired
	private LivroService service;

	@Autowired
	private LivroMapper mapper;

	@PostMapping(path = "/add/")
	public ResponseEntity<LivroDTO> cadastrarLivro(@RequestBody LivroDTO livroDto) {
		LivroEntity livro = mapper.toEntity(livroDto);
		return ResponseEntity.ok().body(mapper.toDTO(service.createLivro(livro)));
	}

	@PutMapping(path = "/atualizar/{codigo}")
	public ResponseEntity<LivroDTO> atualizarLivraria(@PathVariable String codigo, @RequestBody LivroDTO livroDto) {
		UUID idLivro = UUID.fromString(codigo);
		LivroEntity livro = mapper.toEntity(livroDto);
		LivroDTO body = mapper.toDTO(service.updateLivro(idLivro, livro));
		return ResponseEntity.ok().body(body);
	}

	@GetMapping(path = "/livro")
	public ResponseEntity<List<LivroDTO>> findAll() {
		List<LivroDTO> livrosDtos = service.getAllLivros().stream().map(e -> mapper.toDTO(e))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(livrosDtos);
	}

	@DeleteMapping(path = "/deletarLivro/{codigo}")
	public ResponseEntity<Void> delete(@PathVariable String codigo) {
		UUID idLivro = UUID.fromString(codigo);
		service.deleteLivro(idLivro);

		return ResponseEntity.ok().build();
	}
}
