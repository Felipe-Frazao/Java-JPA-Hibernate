package br.com.felipe.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.felipe.loja.dao.ProdutoDao;
import br.com.felipe.loja.modelo.Produto;
import br.com.felipe.loja.util.ConexaoUtil;

public class CadastroProdutos {

	public static void main(String[] args) {
		
		Produto computador = new Produto("Positivo", "8gb de memoria, SSD, I5", new BigDecimal("1080"));
		
		
		EntityManager em = ConexaoUtil.getEntityManager(); 
		ProdutoDao dao = new ProdutoDao(em);
		
		em.getTransaction().begin();//inicia a transacao
		dao.cadastrar(computador); //serve para persistir, salvar e inserir um registro no banco de dados
		em.getTransaction().commit();//commita a acao
		em.close(); //fecha a conexao
	}
		
}
