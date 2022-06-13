package br.com.alura.jdbc.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.ConnectionFactory;
import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.modelo.Produto;

public class TestaInsercaoEListagemComProduto {

	public static void main(String[] args) throws SQLException {

		Produto produtoInsert = new Produto("Geladeira", "Geladeira Electrolux", 3);

		ConnectionFactory connectionFactory = new ConnectionFactory();

		try (Connection connection = connectionFactory.conecta()) {
			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.salvar(produtoInsert);
		//	produtoDao.removerPorId(43);
			List<Produto> produtos = produtoDao.listar();
			produtos.stream().forEach(produto -> System.out.println(produto));

		}
	}
}
