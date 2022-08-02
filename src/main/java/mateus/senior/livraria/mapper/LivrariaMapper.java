package mateus.senior.livraria.mapper;

import org.springframework.stereotype.Service;

import mateus.senior.livraria.dto.LivrariaDTO;
import mateus.senior.livraria.model.entity.LivrariaEntity;

/**
 * 
 * @author Mateus.Nascimento
 *
 */
@Service
public class LivrariaMapper {

	public LivrariaDTO toDTO(LivrariaEntity livraria) {

		LivrariaDTO dto = null;
		if (livraria != null) {

			dto = new LivrariaDTO();

			dto.nome = livraria.getNome();
			dto.email = livraria.getEmail();
			dto.numeroTelefone = livraria.getNumeroTelefone();
			dto.cnpj = livraria.getCnpj();
			dto.livros = livraria.getLivros();

		}
		return dto;
	}

	public LivrariaEntity toEntity(LivrariaDTO dto) {
		LivrariaEntity livraria = null;
		if (dto != null) {
			livraria = new LivrariaEntity();
			livraria.setNome(dto.nome);
			livraria.setEmail(dto.email);
			livraria.setNumeroTelefone(dto.numeroTelefone);
			livraria.setCnpj(dto.cnpj);
			livraria.setLivros(dto.livros);

		}

		return livraria;
	}
}
