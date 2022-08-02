package mateus.senior.livraria.repository;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mateus.senior.livraria.model.entity.LivrariaEntity;

/**
 * 
 * @author Mateus.Nascimento
 *
 */
@Repository
public interface LivrariaRepository extends JpaRepository<LivrariaEntity, UUID> {

	@Transactional
	Optional<LivrariaEntity> findLivrariaByIdLivraria(UUID idLivraria);

	@Transactional
	boolean existsByIdLivraria(UUID idLivraria);

	@Transactional
	void deleteByIdLivraria(UUID idLivraria);

}
