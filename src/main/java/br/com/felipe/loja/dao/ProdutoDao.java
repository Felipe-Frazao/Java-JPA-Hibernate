package br.com.felipe.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.felipe.loja.modelo.Produto;

public class ProdutoDao {

	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}
	
	public Produto buscarProduto(Long id) {
		return em.find(Produto.class, id);
	}
	
	public List<Produto> buscaTodos(){
		String jpql = "Select p from Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}
	
	public List<Produto> buscaPorNome(String nome){
		String jpql = "Select p from Produto p where p.nome = :nome";
		
		return em.createQuery(jpql, Produto.class)
				.setParameter("nome", nome)
				.getResultList();
	}
}
