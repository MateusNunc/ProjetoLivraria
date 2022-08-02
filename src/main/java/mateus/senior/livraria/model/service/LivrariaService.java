package mateus.senior.livraria.model.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mateus.senior.livraria.model.entity.LivrariaEntity;
import mateus.senior.livraria.model.exceptions.LivrariaNotFoundException;
import mateus.senior.livraria.repository.LivrariaRepository;

/**
 * 
 * @author Mateus.Nascimento
 *
 */
@Service
public class LivrariaService {

	@Autowired
	private LivrariaRepository repository;

	public List<LivrariaEntity> getAllLivrarias() {
		Optional<List<LivrariaEntity>> livrarias = Optional.of(repository.findAll());

		if (livrarias.isPresent()) {
			return livrarias.get().stream().filter(Objects::nonNull).collect(Collectors.toList());
		}
		throw new LivrariaNotFoundException("Livrarias não encontradas");
	}

	public LivrariaEntity getLivrariaEntity(UUID idLivraria) {
		Optional<LivrariaEntity> livraria = repository.findLivrariaByIdLivraria(idLivraria);

		if (livraria.isPresent()) {
			return livraria.get();
		}
		throw new LivrariaNotFoundException("Livraria não encontrada");
	}

	public LivrariaEntity createLivraria(LivrariaEntity livraria) {
		return repository.save(livraria);
	}

	public LivrariaEntity updateLivraria(UUID idLivraria, LivrariaEntity livraria) {
		LivrariaEntity oldLivraria = this.getLivrariaEntity(idLivraria);
		oldLivraria.setNome(livraria.getNome());
		oldLivraria.setEmail(livraria.getEmail());
		oldLivraria.setNumeroTelefone(livraria.getNumeroTelefone());
		oldLivraria.setCnpj(livraria.getCnpj());
//		oldLivraria.setLivros(livraria.getLivros());

		return this.createLivraria(oldLivraria);
	}

	public void deleteLivraria(UUID idLivraria) {
		if (!repository.existsById(idLivraria)) {
			throw new LivrariaNotFoundException("Livraria não encontrado");
		}
		repository.deleteById(idLivraria);
	}
}
