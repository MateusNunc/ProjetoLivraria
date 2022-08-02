package mateus.senior.livraria.dto;

import java.util.List;

import mateus.senior.livraria.model.entity.LivroEntity;
import mateus.senior.livraria.model.enumerado.SexoEnum;

public class AutorDTO {

	public String nomeAutor;

	public SexoEnum sexo;

	public List<LivroEntity> livros;
}
