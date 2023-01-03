package br.com.felipe.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.felipe.loja.dao.CategoriaDao;
import br.com.felipe.loja.dao.ClienteDao;
import br.com.felipe.loja.dao.PedidoDao;
import br.com.felipe.loja.dao.ProdutoDao;
import br.com.felipe.loja.modelo.Categoria;
import br.com.felipe.loja.modelo.Cliente;
import br.com.felipe.loja.modelo.ItemPedido;
import br.com.felipe.loja.modelo.Pedido;
import br.com.felipe.loja.modelo.Produto;
import br.com.felipe.loja.util.ConexaoUtil;

public class CadastrarPedido {

	public static void main(String[] args) {
		CadastrarProduto();
		EntityManager em = ConexaoUtil.getEntityManager(); 
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		
		Produto produto = produtoDao.buscarProduto(1l);
		Cliente cliente = clienteDao.buscarCliente(1l);
		
		em.getTransaction().begin();
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItens(new ItemPedido(10, produto ,pedido));

		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastrar(pedido);
		
		em.getTransaction().commit();
		em.close();
	}

	
	private static void CadastrarProduto() {
		
		Cliente cliente = new Cliente("Felipe", "123456");
		Categoria categoria = new Categoria("Tecnologia");
		Produto produto = new Produto("Computador", "8gb de memoria, SSD, I5", new BigDecimal("1080"), categoria);
		
		
		String nome = "Positivo";
		EntityManager em = ConexaoUtil.getEntityManager(); 
		ClienteDao clienteDao = new ClienteDao(em);
		ProdutoDao ProdutoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin();//inicia a transacao
		clienteDao.cadastrar(cliente);
		categoriaDao.cadastrar(categoria);
		ProdutoDao.cadastrar(produto); //serve para persistir, salvar e inserir um registro no banco de dados
		em.getTransaction().commit();//commita a acao
		em.close(); //fecha a conexao
	}
	
	
	
}
