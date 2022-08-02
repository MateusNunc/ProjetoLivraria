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

import mateus.senior.livraria.dto.LivrariaDTO;
import mateus.senior.livraria.mapper.LivrariaMapper;
import mateus.senior.livraria.model.entity.LivrariaEntity;
import mateus.senior.livraria.model.service.LivrariaService;

/**
 * 
 * @author Mateus.Nascimento
 *
 */
@Controller
@RequestMapping(path = "/api/livraria")
public class LivrariaController {

	@Autowired
	private LivrariaService service;

	@Autowired
	private LivrariaMapper mapper;

	@PostMapping(path = "/add/")
	public ResponseEntity<LivrariaDTO> cadastrarLivraria(@RequestBody LivrariaDTO livrariaDto) {
		LivrariaEntity livraria = mapper.toEntity(livrariaDto);
		return ResponseEntity.ok().body(mapper.toDTO(service.createLivraria(livraria)));
	}

	@PutMapping(path = "atualizar/{codigo}")
	public ResponseEntity<LivrariaDTO> atualizarLivraria(@PathVariable String codigo,
			@RequestBody LivrariaDTO livrariaDto) {
		UUID idLivraria = UUID.fromString(codigo);
		LivrariaEntity livraria = mapper.toEntity(livrariaDto);
		LivrariaDTO body = mapper.toDTO(service.updateLivraria(idLivraria, livraria));
		return ResponseEntity.ok().body(body);
	}

	@GetMapping(path = "/livraria")
	public ResponseEntity<List<LivrariaDTO>> findAll() {
		List<LivrariaDTO> livrariasDtos = service.getAllLivrarias().stream().map(e -> mapper.toDTO(e))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(livrariasDtos);
	}

	@DeleteMapping(path = "/deletarLivraria/{codigo}")
	public ResponseEntity<Void> delete(@PathVariable String codigo) {
		UUID idLivraria = UUID.fromString(codigo);
		service.deleteLivraria(idLivraria);

		return ResponseEntity.ok().build();
	}
}
