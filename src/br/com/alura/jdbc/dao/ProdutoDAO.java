package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

public class ProdutoDAO {
	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Produto produto) throws SQLException {

		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO, CATEGORIA_ID) VALUES (?, ?, ?)";

		try (PreparedStatement stat = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stat.setString(1, produto.getNome());
			stat.setString(2, produto.getDescricao());
			stat.setInt(3, produto.getCategoriaId());
			stat.execute();

			try (ResultSet result = stat.getGeneratedKeys()) {
				while (result.next()) {
					produto.setId(result.getInt(1));
				}
			}
		}

	}

	public List<Produto> listar() throws SQLException {
		List<Produto> produtos = new ArrayList<>();

		String sql = "SELECT * FROM PRODUTO";
		try (PreparedStatement stat = connection.prepareStatement(sql)) {
			stat.execute();

			try (ResultSet result = stat.getResultSet()) {
				while (result.next()) {

					Produto produto = new Produto(result.getInt(1), result.getString(2), result.getString(3),
							result.getInt(4));
					produtos.add(produto);
				}
			}
		}
		return produtos;
	}

	public void removerPorId(Integer id) throws SQLException {
		String sql = "DELETE FROM PRODUTO WHERE ID = ?";
		try (PreparedStatement stat = connection.prepareStatement(sql)) {
			stat.setInt(1, id);
			stat.execute();
			Integer linhasModificadas = stat.getUpdateCount();
			System.out.println("Numero de linhas modificadas " + linhasModificadas);
		}
	}

	public List<Produto> buscar(Categoria categoria) throws SQLException {
		List<Produto> produtos = new ArrayList<>();

		String sql = "SELECT * FROM PRODUTO WHERE CATEGORIA_ID = ?";
		try (PreparedStatement stat = connection.prepareStatement(sql)) {
			stat.setInt(1, categoria.getId());
			stat.execute();

			try (ResultSet result = stat.getResultSet()) {
				while (result.next()) {

					Produto produto = new Produto(result.getInt(1), result.getString(2), result.getString(3),
							result.getInt(4));
					produtos.add(produto);
				}
			}
		}
		return produtos;
	}
}