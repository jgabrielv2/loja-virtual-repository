package br.com.alura.jdbc.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.ConnectionFactory;
import br.com.alura.jdbc.dao.CategoriaDAO;
import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

public class TestaListagemDeCategoria {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();

		try (Connection connection = connectionFactory.conecta()) {

			CategoriaDAO categoriaDao = new CategoriaDAO(connection);

			// categoriaDao.salvar(new Categoria("automoveis"));

			List<Categoria> categorias = categoriaDao.listarComProdutos();
			categorias.stream().forEach(categoria -> {
				System.out.println(categoria.getNome());

//				try {
//					for (Produto produto : new ProdutoDAO(connection).buscar(categoria)) {
//						System.out.println(categoria.getNome() + " - " + produto.getNome());
//					}
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
			});
		}
	}
}