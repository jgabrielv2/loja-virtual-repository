package br.com.alura.jdbc.test;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.jdbc.ConnectionFactory;

public class TestaConexao {
	public static void main(String[] args) throws SQLException {
		System.out.println("Abrindo conexao");
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.conecta();
		con.close();
		System.out.println("Conexao fechada");
	}
}
