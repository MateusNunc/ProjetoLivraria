package mateus.senior.livraria.model.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Mateus.Nascimento
 *
 */
@Entity(name = "LivrariaEntity")
@Table(name = "livraria")
public class LivrariaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_livraria")
	private UUID idLivraria;

	@Column(name = "nome_livraria", nullable = false)
	private String nome;

	@Column(name = "email_livraria", nullable = false)
	private String email;

	@Column(name = "numero_telefone_livraria", nullable = false)
	private String numeroTelefone;

	@Column(name = "cnpj_livraria", nullable = false)
	private String cnpj;

	@OneToMany(mappedBy = "bookStore", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LivroEntity> livros;

	public LivrariaEntity(String nome, String email, String numeroTelefone, String cnpj, List<LivroEntity> livros) {
		super();
		this.nome = nome;
		this.email = email;
		this.numeroTelefone = numeroTelefone;
		this.cnpj = cnpj;
		this.livros = livros;
	}

	public LivrariaEntity() {
		super();
	}

	public UUID getIdLivraria() {
		return idLivraria;
	}

	public void setIdLivraria(UUID idLivraria) {
		this.idLivraria = idLivraria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<LivroEntity> getLivros() {
		return livros;
	}

	public void setLivros(List<LivroEntity> livros) {
		this.livros = livros;
	}

}
