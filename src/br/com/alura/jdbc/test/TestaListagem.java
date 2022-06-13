package br.com.alura.jdbc.test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.alura.jdbc.ConnectionFactory;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {
		System.out.println("Abrindo conexao");

		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		Connection con = connectionFactory.conecta();
		
		PreparedStatement stm = con.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		stm.execute();
		ResultSet result = stm.getResultSet();

		while (result.next()) {
			Integer id = result.getInt("ID");
			System.out.println(id);
			String nome = result.getString("NOME");
			System.out.println(nome);
			String descricao = result.getString("DESCRICAO");
			System.out.println(descricao);
		}

		con.close();
		System.out.println("Conexao fechada");
	}
}