package mateus.senior.livraria.model.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mateus.senior.livraria.model.entity.AutorEntity;
import mateus.senior.livraria.model.exceptions.AutorNotFoundException;
import mateus.senior.livraria.repository.AutorRepository;

/**
 * 
 * @author Mateus.Nascimento
 *
 */
@Service
public class AutorService {

	@Autowired
	private AutorRepository repository;

	public List<AutorEntity> getAllAutores() {
		Optional<List<AutorEntity>> autores = Optional.of(repository.findAll());

		if (autores.isPresent()) {
			return autores.get().stream().filter(Objects::nonNull).collect(Collectors.toList());
		}
		throw new AutorNotFoundException("Autores não encontrados");
	}

	public AutorEntity getAutorEntity(UUID idAutor) {
		Optional<AutorEntity> departamento = repository.findAutorByIdAutor(idAutor);

		if (departamento.isPresent()) {
			return departamento.get();
		}
		throw new AutorNotFoundException("Autor não encontrado");
	}

	public AutorEntity createAutor(AutorEntity autor) {
		return repository.save(autor);
	}

	public AutorEntity updateAutor(UUID idAutor, AutorEntity autor) {
		AutorEntity oldAutor = this.getAutorEntity(idAutor);
		oldAutor.setNomeAutor(autor.getNomeAutor());
		oldAutor.setSexo(autor.getSexo());
		oldAutor.setLivros(autor.getLivros());

		return this.createAutor(oldAutor);
	}

	public void deleteAutor(UUID idAutor) {
		if (!repository.existsById(idAutor)) {
			throw new AutorNotFoundException("Autor não encontrado");
		}
		repository.deleteById(idAutor);
	}

}
