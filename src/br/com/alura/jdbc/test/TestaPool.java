package br.com.alura.jdbc.test;
import java.sql.SQLException;

import br.com.alura.jdbc.ConnectionFactory;

public class TestaPool {
	public static void main(String[] args) throws SQLException {

		ConnectionFactory connection = new ConnectionFactory();

		for (int i = 1; i <= 20; i++) {
			connection.conecta();
			System.out.println("Conexao numero " + i);
		}

	}
}
