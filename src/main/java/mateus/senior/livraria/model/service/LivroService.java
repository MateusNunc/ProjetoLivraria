package mateus.senior.livraria.model.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mateus.senior.livraria.model.entity.LivroEntity;
import mateus.senior.livraria.model.exceptions.LivroNotFoundException;
import mateus.senior.livraria.repository.LivroRepository;

/**
 * 
 * @author Mateus.Nascimento
 *
 */
@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	public List<LivroEntity> getAllLivros() {
		Optional<List<LivroEntity>> livros = Optional.of(repository.findAll());

		if (livros.isPresent()) {
			return livros.get().stream().filter(Objects::nonNull).collect(Collectors.toList());
		}
		throw new LivroNotFoundException("Livros não encontrados");
	}

	public LivroEntity getLivroEntity(UUID idLivro) {
		Optional<LivroEntity> livro = repository.findLivroByIdLivro(idLivro);

		if (livro.isPresent()) {
			return livro.get();
		}
		throw new LivroNotFoundException("Livro não encontrado");
	}

	public LivroEntity createLivro(LivroEntity livro) {
		return repository.save(livro);
	}

	public LivroEntity updateLivro(UUID idLivro, LivroEntity livro) {
		LivroEntity oldLivro = this.getLivroEntity(idLivro);
		oldLivro.setTitulo(livro.getTitulo());
		oldLivro.setDescricao(livro.getDescricao());
		oldLivro.setPreco(livro.getPreco());
		oldLivro.setDataLancamento(livro.getDataLancamento());
		oldLivro.setBookStore(livro.getBookStore());
		oldLivro.setAutores(livro.getAutores());

		return this.createLivro(oldLivro);
	}

	public void deleteLivro(UUID idLivro) {
		if (!repository.existsById(idLivro)) {
			throw new LivroNotFoundException("Livro não encontrado");
		}
		repository.deleteById(idLivro);
	}
}
