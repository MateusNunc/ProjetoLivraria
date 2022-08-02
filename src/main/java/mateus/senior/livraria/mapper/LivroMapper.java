package mateus.senior.livraria.mapper;

import org.springframework.stereotype.Service;

import mateus.senior.livraria.dto.LivroDTO;
import mateus.senior.livraria.model.entity.LivroEntity;

/**
 * 
 * @author Mateus.Nascimento
 *
 */
@Service
public class LivroMapper {

	public LivroDTO toDTO(LivroEntity livro) {

		LivroDTO dto = null;
		if (livro != null) {

			dto = new LivroDTO();

			dto.titulo = livro.getTitulo();
			dto.descricao = livro.getDescricao();
			dto.preco = livro.getPreco();
			dto.dataLancamento = livro.getDataLancamento();
			dto.bookStore = livro.getBookStore();
			dto.autores = livro.getAutores();
		}
		return dto;
	}

	public LivroEntity toEntity(LivroDTO dto) {
		LivroEntity livro = null;
		if (dto != null) {
			livro = new LivroEntity();
			livro.setTitulo(dto.titulo);
			livro.setDescricao(dto.descricao);
			livro.setPreco(dto.preco);
			livro.setDataLancamento(dto.dataLancamento);
			livro.setBookStore(dto.bookStore);
			livro.setAutores(dto.autores);
		}

		return livro;
	}
}
