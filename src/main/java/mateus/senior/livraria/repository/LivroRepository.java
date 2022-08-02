package mateus.senior.livraria.repository;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mateus.senior.livraria.model.entity.LivroEntity;

/**
 * 
 * @author Mateus.Nascimento
 *
 */
@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, UUID> {

	@Transactional
	Optional<LivroEntity> findLivroByIdLivro(UUID idLivro);

	@Transactional
	boolean existsByIdLivro(UUID idLivro);

	@Transactional
	void deleteByIdLivro(UUID idLivro);
}
