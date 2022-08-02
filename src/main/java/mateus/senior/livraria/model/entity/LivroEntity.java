package mateus.senior.livraria.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Mateus.Nascimento
 *
 */
@Entity(name = "LivroEntity")
@Table(name = "livro")
public class LivroEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_livro")
	private UUID idLivro;

	@Column(name = "titulo_livro", nullable = false)
	private String titulo;

	@Column(name = "descricao_livro", nullable = false)
	private String descricao;

	@Column(name = "preco_livro", nullable = false)
	private BigDecimal preco;

	@Column(name = "data_lancamento_livro", nullable = true)
	private LocalDate dataLancamento;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "livraria", referencedColumnName = "id_livraria")
	private LivrariaEntity bookStore;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "autor_livro", joinColumns = {
			@JoinColumn(name = "livro", referencedColumnName = "id_livro") }, inverseJoinColumns = {
					@JoinColumn(name = "autor", referencedColumnName = "id_autor") })
	private List<AutorEntity> autores;

	public LivroEntity(String titulo, String descricao, BigDecimal preco, LocalDate dataLancamento,
			LivrariaEntity bookStore, List<AutorEntity> autores) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.preco = preco;
		this.dataLancamento = dataLancamento;
		this.bookStore = bookStore;
		this.autores = autores;
	}

	public LivroEntity() {
		super();
	}

	public UUID getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(UUID idLivro) {
		this.idLivro = idLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public LivrariaEntity getBookStore() {
		return bookStore;
	}

	public void setBookStore(LivrariaEntity bookStore) {
		this.bookStore = bookStore;
	}

	public List<AutorEntity> getAutores() {
		return autores;
	}

	public void setAutores(List<AutorEntity> autores) {
		this.autores = autores;
	}

}
