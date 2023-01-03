package br.com.felipe.loja.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Itens_Pedidos")
public class ItemPedido {

	public ItemPedido() {
	}

	public ItemPedido(int quantidade, Produto produto, Pedido pedido) {
		this.quantidade = quantidade;
		this.precoUnitario = produto.getPreco();
		this.produto = produto;
		this.pedido = pedido;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(name = "preco_unitario")
	private BigDecimal precoUnitario;
	private int quantidade;

	@ManyToOne
	private Produto produto;
	@ManyToOne
	private Pedido pedido;

	public int getUnidade() {
		return quantidade;
	}

	public void setUnidade(int unidade) {
		this.quantidade = unidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
