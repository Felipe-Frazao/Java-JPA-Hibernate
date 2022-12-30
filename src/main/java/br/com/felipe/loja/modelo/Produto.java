package br.com.felipe.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity // Uma entidade JPA funciona como um espelho de uma tabela no banco de dados
@Table(name = "produtos") // estamos dizendo que no banco a tabela que esta sendo mapeada possui o name produtos, sem essa anotation a JPA ira utilizar como padrao o nome da classe
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private LocalDate data = LocalDate.now();
	
	@ManyToOne
	private Categoria categoria;

	Produto(){} //deve ser adicionado um construtor vazio
	
	public Produto(String produto, String descricao, BigDecimal preco, Categoria categoria) {
		this.nome = produto;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProduto() {
		return nome;
	}

	public void setProduto(String produto) {
		this.nome = produto;
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

}
