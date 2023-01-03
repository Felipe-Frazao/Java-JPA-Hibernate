package br.com.felipe.loja.dao;

import javax.persistence.EntityManager;

import br.com.felipe.loja.modelo.Cliente;

public class ClienteDao {

	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Cliente cliente) {
		this.em.persist(cliente);
	}

	public Cliente buscarCliente(long id) {
		return em.find(Cliente.class, id);
	}

}
