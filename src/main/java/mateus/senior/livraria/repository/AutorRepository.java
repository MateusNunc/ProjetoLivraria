package mateus.senior.livraria.repository;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mateus.senior.livraria.model.entity.AutorEntity;

/**
 * 
 * @author Mateus.Nascimento
 *
 */
@Repository
public interface AutorRepository extends JpaRepository<AutorEntity, UUID> {

	@Transactional
	Optional<AutorEntity> findAutorByIdAutor(UUID idAutor);

	@Transactional
	boolean existsByIdAutor(UUID idAutor);

	@Transactional
	void deleteByIdAutor(UUID idAutor);

}
