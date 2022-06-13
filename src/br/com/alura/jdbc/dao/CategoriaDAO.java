package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Categoria;

public class CategoriaDAO {

	private Connection connection;

	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Categoria categoria) throws SQLException {
		String sql = "INSERT INTO CATEGORIA (NOME) VALUES (?)";
		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, categoria.getNome());
		statement.execute();

		try (ResultSet result = statement.getGeneratedKeys()) {
			while (result.next()) {
				categoria.setId(result.getInt(1));
			}
		}

	}

	public List<Categoria> listar() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();
		String sql = "SELECT ID, NOME FROM CATEGORIA";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.execute();

			try (ResultSet result = statement.getResultSet()) {
				while (result.next()) {
					Categoria categoria = new Categoria(result.getInt(1), result.getString(2));
					categorias.add(categoria);
				}

			}

		}
		return categorias;
	}

	public List<Categoria> listarComProdutos() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();
		String sql = "SELECT C.ID, C.NOME, P.ID, P.NOME, P.DESCRICAO FROM CATEGORIA C INNER JOIN PRODUTO P ON C.ID = P.CATEGORIA_ID;";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.execute();

			try (ResultSet result = statement.getResultSet()) {
				while (result.next()) {
					Categoria categoria = new Categoria(result.getInt(1), result.getString(2));
					categorias.add(categoria);
				}

			}

		}
		return categorias;
	}
}
