package br.com.felipe.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.felipe.loja.dao.CategoriaDao;
import br.com.felipe.loja.dao.ProdutoDao;
import br.com.felipe.loja.modelo.Categoria;
import br.com.felipe.loja.modelo.Produto;
import br.com.felipe.loja.util.ConexaoUtil;

public class CadastroProdutos {

	public static void main(String[] args) {
		
		Categoria categoria = new Categoria("Tecnologia");
		Produto produto = new Produto("Positivo", "8gb de memoria, SSD, I5", new BigDecimal("1080"), categoria);
		
		String nome = "Xiaomi";
		EntityManager em = ConexaoUtil.getEntityManager(); 
		ProdutoDao ProdutoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		categoriaDao.cadastrar(categoria);
		em.getTransaction().begin();
		
		List<Produto> produtos = ProdutoDao.buscaPorNome(nome);
		produtos.forEach(p -> System.out.println(p.getProduto()));
		Produto p = ProdutoDao.buscarProduto(2l);
		System.out.println(p.getDescricao());
		
		em.getTransaction().commit();
		em.close();
		
//		em.getTransaction().begin();//inicia a transacao
//		categoriaDao.cadastrar(categoria);
//		ProdutoDao.cadastrar(produto); //serve para persistir, salvar e inserir um registro no banco de dados
//		em.getTransaction().commit();//commita a acao
//		em.close(); //fecha a conexao
//	
	}
		
}
