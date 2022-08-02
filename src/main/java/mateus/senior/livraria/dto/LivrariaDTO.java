package mateus.senior.livraria.dto;

import java.util.List;

import mateus.senior.livraria.model.entity.LivroEntity;

public class LivrariaDTO {

	public String nome;

	public String email;

	public String numeroTelefone;

	public String cnpj;

	public List<LivroEntity> livros;
}
