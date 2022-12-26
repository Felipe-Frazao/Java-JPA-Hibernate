package br.com.felipe.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.felipe.loja.modelo.Produto;

public class CadastroProdutos {

	public static void main(String[] args) {
		
		Produto celular = new Produto("Xiaomi", "Celular com muitas utilidades", new BigDecimal("1080"));
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");// a string e o nome do <persistence-unit>
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();//inicia a transacao
		em.persist(celular);//serve para persistir, salvar e inserir um registro no banco de dados
		em.getTransaction().commit();//commita a acao
		em.close(); //fecha a conexao
	}

}
