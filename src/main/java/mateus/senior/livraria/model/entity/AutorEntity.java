package mateus.senior.livraria.model.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import mateus.senior.livraria.model.enumerado.SexoEnum;

/**
 *
 * @author Mateus.Nascimento
 *
 */
@Entity(name = "AutorEntity")
@Table(name = "autor")
public class AutorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_autor")
	private UUID idAutor;

	@Column(name = "nome_autor", nullable = false)
	private String nomeAutor;

	@Column(name = "sexo_autor", nullable = true)
	@Enumerated(EnumType.STRING)
	private SexoEnum sexo;

	@ManyToMany(mappedBy = "autores", cascade = CascadeType.ALL)
	private List<LivroEntity> livros;

	public AutorEntity(String nomeAutor, SexoEnum sexo, List<LivroEntity> livros) {
		super();
		this.nomeAutor = nomeAutor;
		this.sexo = sexo;
		this.livros = livros;
	}

	public AutorEntity() {
		super();
	}

	public UUID getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(UUID idAutor) {
		this.idAutor = idAutor;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	public List<LivroEntity> getLivros() {
		return livros;
	}

	public void setLivros(List<LivroEntity> livros) {
		this.livros = livros;
	}

}
