package mateus.senior.livraria.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import mateus.senior.livraria.model.entity.AutorEntity;
import mateus.senior.livraria.model.entity.LivrariaEntity;

public class LivroDTO {

	public String titulo;

	public String descricao;

	public BigDecimal preco;

	public LocalDate dataLancamento;

	public LivrariaEntity bookStore;

	public List<AutorEntity> autores;
}
