package mateus.senior.livraria.mapper;

import org.springframework.stereotype.Service;

import mateus.senior.livraria.dto.AutorDTO;
import mateus.senior.livraria.model.entity.AutorEntity;

/**
 * 
 * @author Mateus.Nascimento
 *
 */
@Service
public class AutorMapper {

	public AutorDTO toDTO(AutorEntity autor) {

		AutorDTO dto = null;
		if (autor != null) {

			dto = new AutorDTO();

			dto.nomeAutor = autor.getNomeAutor();
			dto.sexo = autor.getSexo();
			dto.livros = autor.getLivros();

		}
		return dto;
	}

	public AutorEntity toEntity(AutorDTO dto) {

		AutorEntity autor = null;
		if (dto != null) {
			autor = new AutorEntity();
			autor.setNomeAutor(dto.nomeAutor);
			autor.setSexo(dto.sexo);
			autor.setLivros(dto.livros);

		}
		return autor;
	}
}